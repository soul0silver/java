package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRepo {
    public static Connection getConnect() throws SQLException {
        String url="jdbc:mysql://localhost:3307/new_db";
        String username="root";
        String password="";
        Connection connection= DriverManager.getConnection(url,username,password);
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
    public int create(User user) throws SQLException {
        Connection connection=getConnect();
        PreparedStatement statement=connection.prepareStatement("insert into user(username ,password) values (?,?)");
        statement.setString(1,user.getUsername());
        statement.setString(2,user.getPassword());
        int res= statement.executeUpdate();
        close(statement);
        close(connection);
        return res;
    }

    public String checkLogin(String username,String password) throws SQLException {
        Connection connection=getConnect();
        PreparedStatement statement=connection.prepareStatement("select * from user where username=? and password=?");
        statement.setString(1,username);
        statement.setString(2,password);
        ResultSet set=statement.executeQuery();
        try {
            while ((set.next())) {
                System.out.println(set.getString(2));
                return set.getString(2);
            }
            return "Not found";
        }catch (SQLException e){
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"",e);
            return "false";
        }finally {
            close(set);
            close(statement);
            close(connection);
        }


    }

}
