package service;

import modal.Book;
import modal.BookDTO;
import modal.Borrow;

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

    public String viewBook() throws SQLException {
        List<BookDTO> books = new ArrayList<>();

        Connection connection = getConnect();
        PreparedStatement statement = connection.prepareStatement("select b.*,bo.quantity from book b,borrow bo where b.code=bo.bid ");
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            BookDTO book=new BookDTO() ;
            book.setCode(set.getInt(1));
            book.setName(set.getString(2));
            book.setAuth(set.getString(3));
            book.setQuantity(set.getInt(4));
            book.setBorrow(set.getInt(5));
            books.add(book);
        }
        close(set);
        close(statement);
        close(connection);
        return books.toString();
    }

    public String borrow(int code, int bo) throws SQLException {
        Book book = searchByCode(code);
        book.setQuantity(book.getQuantity() - bo);
        Connection connection = getConnect();
        PreparedStatement statement =
                connection.prepareStatement("update  book set quantity=? where code=?");
        statement.setInt(2, code);
        statement.setInt(1, book.getQuantity());
        int e=statement.executeUpdate();
        Borrow borrow=searchByBid(code);
        borrow.setQuantity(borrow.getQuantity()+bo);
        PreparedStatement statement1 =
                connection.prepareStatement("update  borrow set quantity=? where id=?");
        statement1.setInt(2, borrow.getId());
        statement1.setInt(1, borrow.getQuantity());
        int b=statement1.executeUpdate();
        PreparedStatement statement2 = connection.prepareStatement("insert into ticket( dateborrow ,des,datereturn,status) values (?,?,?,?)");
        statement2.setString(1, new Date().toString());
        statement2.setString(2, "");
        statement2.setString(3, "");
        statement2.setBoolean(4,true);
        close(statement1);
        close(statement2);
        close(statement);
        close(connection);
        return "done";
    }
    public String lend(int code) throws SQLException {
        Connection connection = getConnect();
        Borrow borrow=searchByBid(code);
        borrow.setQuantity(0);
        PreparedStatement statement1 =
                connection.prepareStatement("update  borrow set quantity=? where id=?");
        statement1.setInt(2, borrow.getId());
        statement1.setInt(1, borrow.getQuantity());
        int b=statement1.executeUpdate();
        Book book = searchByCode(code);
        book.setQuantity(book.getQuantity() + borrow.getQuantity());
        PreparedStatement statement =
                connection.prepareStatement("update  book set quantity=? where code=?");
        statement.setInt(2, code);
        statement.setInt(1, book.getQuantity());
        int e=statement.executeUpdate();
        close(statement1);
        close(statement);
        close(connection);
        return "done";
    }

    public Borrow searchByBid(int bid) throws SQLException {
        Borrow borrow = new Borrow();
        Connection connection = getConnect();
        PreparedStatement statement = connection.prepareStatement("select * from borrow where bid=?");
        statement.setInt(1, bid);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            borrow.setId(set.getInt(1));
            borrow.setBid(set.getInt(2));
            borrow.setQuantity(set.getInt(3));

        }
        close(set);
        close(statement);
        close(connection);

        return borrow;
    }
}
