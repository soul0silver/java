package service;

import modal.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibraryService {
    public static Connection getConnect() throws SQLException {
        String url = "jdbc:mysql://localhost:3307/mypj";
        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public static void close(Statement statement) throws SQLException {
        statement.close();

    }

    public static void close(Connection connection) throws SQLException {
        connection.close();

    }

    public static void close(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }

    public String addBook(Book book) throws SQLException {
        Connection connection = getConnect();
        PreparedStatement statement = connection.prepareStatement("insert into book( name ,auth,quantity) values (?,?,?)");
        statement.setString(1, book.getName());
        statement.setString(2, book.getAuth());
        statement.setInt(3, book.getQuantity());
        int res = statement.executeUpdate();
        Book book1 = searchByName(book.getName());
        PreparedStatement statement1 = connection.prepareStatement("insert into borrow(bid,quantity) values (?,0)");
        statement1.setInt(1, book1.getCode());

        int res1 = statement1.executeUpdate();
        close(statement);
        close(connection);
        if (res > 0)
            return "Create ss";
        return "";
    }

    public Book searchByCode(int code) throws SQLException {
        Book book = new Book();
        Connection connection = getConnect();
        PreparedStatement statement = connection.prepareStatement("select * from book where code=?");
        statement.setInt(1, code);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            book.setCode(set.getInt(1));
            book.setName(set.getString(2));
            book.setAuth(set.getString(3));
            book.setQuantity(set.getInt(4));
        }
        close(set);
        close(statement);
        close(connection);

        return book;
    }

    public Book searchByName(String name) throws SQLException {
        Book book = new Book();
        Connection connection = getConnect();
        PreparedStatement statement = connection.prepareStatement("select * from book where name=?");
        statement.setString(1, name);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            book.setCode(set.getInt(1));
            book.setName(set.getString(2));
            book.setAuth(set.getString(3));
            book.setQuantity(set.getInt(4));
        }
        close(set);
        close(statement);
        close(connection);

        return book;
    }

    public List<BookDTO> viewBook() throws SQLException {
        List<BookDTO> books = new ArrayList<>();

        Connection connection = getConnect();
        PreparedStatement statement = connection.prepareStatement("select * from book b");
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            BookDTO book = new BookDTO();
            book.setCode(set.getInt(1));
            book.setName(set.getString(2));
            book.setAuth(set.getString(3));
            book.setQuantity(set.getInt(4));
            books.add(book);
        }
        for (BookDTO bo : books) {
            PreparedStatement statement1 =
                    connection.prepareStatement("select s.q from ticket t, " +
                    "(select sum(quan) q,bid,tid " +
                    "from ticket_details where bid=?  group by bid)as s where s.tid=t.id and t.status=false");
            statement1.setInt(1,bo.getCode());
            ResultSet set1 = statement1.executeQuery();
            while (set1.next()) {
                System.out.println(set1.getInt(1));
                bo.setBorrow(set1.getInt(1));
                break;
            }
            close(set1);
            close(statement1);
        }

        close(connection);
        return books;
    }

    public String borrow(List<Book> books, Ticket ticket) throws SQLException {
        Connection connection = getConnect();

        PreparedStatement statement1 =
                connection.prepareStatement("insert into ticket(dateborrow,des,datereturn,status,sid) values (?,?,?,?,?)");
        statement1.setString(1, ticket.getDateBorrow());
        statement1.setString(2, ticket.getDes());
        statement1.setString(3, ticket.getDatReturn());
        statement1.setBoolean(4, false);
        statement1.setInt(5,ticket.getSid());
        int b = statement1.executeUpdate();

        PreparedStatement statement = connection.prepareStatement("select * from ticket where sid=? and dateborrow=?");
        statement.setInt(1, ticket.getSid());
        statement.setString(2, ticket.getDateBorrow());
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            ticket.setSid(set.getInt(1));
        }
        for (Book i : books) {
            PreparedStatement statement2 = connection.prepareStatement("insert into ticket_details( tid ,bid,quan) values (?,?,?)");
            statement2.setInt(1, ticket.getId());
            statement2.setInt(2, i.getCode());
            statement2.setInt(3, i.getQuantity());

            int c = statement2.executeUpdate();
            close(statement2);
        }
        close(statement1);
        close(connection);
        return "done";
    }

    public String lend(Ticket ticket) throws SQLException {
        int c = 0;
        Connection connection = getConnect();
        PreparedStatement statement1 =
                connection.prepareStatement("update  ticket set status=? where id=?");
        statement1.setInt(2, ticket.getId());
        statement1.setBoolean(1, true);
        int b = statement1.executeUpdate();
        close(statement1);
        close(connection);
        return "done";
    }

    public List<Ticket> searchTicket(int sid) throws SQLException {
        List<Ticket> list = new ArrayList<>();
        Connection connection = getConnect();
        PreparedStatement statement = connection.prepareStatement("select * from ticket where sid=? and status=?");
        statement.setInt(1, sid);
        statement.setBoolean(2, false);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Ticket ticket = new Ticket();
            ticket.setId(set.getInt(1));
            ticket.setDateBorrow(set.getString(2));
            ticket.setDes(set.getString(3));
            ticket.setDatReturn(set.getString(4));
            ticket.setStatus(set.getBoolean(5));
            ticket.setSid(set.getInt(6));
            list.add(ticket);
        }
        close(set);
        close(statement);
        close(connection);

        return list;
    }

    public List<TicketDetails> getList(int tid) throws SQLException {
        List<TicketDetails> list = new ArrayList<>();
        Connection connection = getConnect();
        PreparedStatement statement = connection.prepareStatement("select * from ticket_details where tid=? ");
        statement.setInt(1, tid);

        ResultSet set = statement.executeQuery();
        while (set.next()) {
            TicketDetails ticket = new TicketDetails();
            ticket.setId(set.getInt(1));
            ticket.setTid(set.getInt(2));
            ticket.setBid(set.getInt(3));
            ticket.setQuantity(set.getInt(4));
            list.add(ticket);
        }
        close(set);
        close(statement);
        close(connection);
        return list;
    }

    public boolean checkQuan(int code, int quan) throws SQLException {
        Connection connection = getConnect();
        PreparedStatement statement =
                connection.prepareStatement("select s.q from ticket t, " +
                        "(select sum(quan) q,bid,tid " +
                        "from ticket_details where bid=?  group by bid)as s where s.tid=t.id and t.status=false");
        statement.setInt(1,code);
        ResultSet set = statement.executeQuery();
        Borrow borrow=new Borrow();
        while (set.next()){
            borrow.setBid(code);
            borrow.setQuantity(set.getInt(1));
        }
        Book book = searchByCode(code);
        if (book.getQuantity() >= (borrow.getQuantity() + quan))
            return true;
        return false;
    }

}
