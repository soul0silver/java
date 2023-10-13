package newProject;

import java.sql.*;

public class MySqlConnectionEX {


    public static Connection getConnection() throws SQLException {
        String host="localhost";
        String dbname="mypj";
        String username="root";
        String password="";

        String connectURL="jdbc:mysql://"+host+":3307/"+dbname;
        Connection connection= DriverManager.getConnection(connectURL,username,password);
        return connection;
    }
    static void crud() throws SQLException{
        Connection connection=getConnection();
        String query="drop table if exists `user` " ;
        String q=        "create table user (\n" +
                "    id int primary key ,\n" +
                "    username varchar(50),\n" +
                "    password varchar(50)\n" +
                ");";
        Statement statement=connection.createStatement();
        statement.execute(query);
        statement.execute(q);
        String q2="insert into user values (1,'admin','admin')";
        statement.executeUpdate(q2);
    }

    static void login(String username,String password) throws SQLException {
        Connection connection=getConnection();

        String q2="select username from user where username = ? and password=?";

        //tao prepare statement

        PreparedStatement statement=connection.prepareStatement(q2);
        statement.setString(1,username);
        statement.setString(2,password);

        ResultSet re=statement.executeQuery();

        while (re.next()){
            System.out.println("Username: "+re.getString(1));
        }


    }

    public static void main(String[] args) throws SQLException {
//        crud();
        login("admin","admin");
    }
}
