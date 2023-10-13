package AptechBank;

import java.sql.*;

public class Repo {
    public Repo() {
    }

    public  Connection getConnection() throws SQLException {
        String host="localhost";
        String dbname="mypj";
        String username="root";
        String password="";

        String connectURL="jdbc:mysql://"+host+":3307/"+dbname;
        Connection connection= DriverManager.getConnection(connectURL,username,password);
        return connection;
    }
    public void createTB() throws SQLException {
        Connection connection =getConnection();
        PreparedStatement statement=connection.prepareStatement("create table customer(id int primary key ,name nvarchar(255)); ");
        statement.execute();
        statement.close();
    }
    public void createCus(String name,int id ) throws SQLException {
        Connection connection =getConnection();
        PreparedStatement statement=connection.prepareStatement("insert into customer values ("+ id+",'"+name+"'); ");
        boolean c= statement.execute();
        if (c==true) System.out.println("ss");
        statement.close();
    }
    public void updateCus(String name,int id ) throws SQLException {
        Connection connection =getConnection();
        PreparedStatement statement=connection.prepareStatement("update customer  set name ='"+name+"' where id="+ id );
        int c= statement.executeUpdate();
        if (c>0) System.out.println("ss");
        statement.close();
    }

    public void delCus(String name ) throws SQLException {
        Connection connection =getConnection();
        PreparedStatement statement=connection.prepareStatement("delete from customer where name="+ name );
        int c= statement.executeUpdate();
        if (c>0) System.out.println("ss");
        statement.close();
    }

    Customer find(int id) throws SQLException {
        Customer customer=new Customer();
        Connection connection =getConnection();
        PreparedStatement statement=connection.prepareStatement("select * from customer where id="+ id );
        ResultSet c= statement.executeQuery();
        while (c.next()){
            customer.setId(c.getInt(1));
            customer.setName(c.getString(2));
        }
        statement.close();
        return customer;
    }
    void displayAll() throws SQLException {
        Connection connection =getConnection();
        PreparedStatement statement=connection.prepareStatement("select * from customer" );
        ResultSet c= statement.executeQuery();
        while (c.next()){
            System.out.println(c.getInt(1)+"-"+c.getString(2));
        }
        statement.close();
    }
}
