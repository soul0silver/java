package jdbcApp;

import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.cj.jdbc.JdbcConnection;

import java.sql.*;

public class Repository {
    public static Connection getConnection() throws SQLException {
        String host="localhost";
        String dbname="mypj";
        String username="root";
        String password="";

        String connectURL="jdbc:mysql://"+host+":3307/"+dbname;
        Connection connection= DriverManager.getConnection(connectURL,username,password);
        return connection;
    }

    static void creatEmployee() throws SQLException {
        //1.connect
        Connection connection=getConnection();
        //2. thuc thi
        Statement statement=connection.createStatement();
        //tao query
        String query="insert into employee(id,name,address) "+
                "values(1,'Vinh','HN')";
        //4.insert
        int count= statement.executeUpdate(query);

        System.out.println("Count: "+count);
    }

    static void getEmp() throws SQLException {
        Connection connection=getConnection();
        Statement statement=connection.createStatement();
        String q="select * from employee";
        ResultSet set=statement.executeQuery(q);
        while (set.next()){
            int id=set.getInt(1);
            String name= set.getString(2);
            String address= set.getString(3);
            System.out.println(id+"-"+name+"-"+address);
        }
    }

    static void delEmp() throws SQLException {

            Connection connection = getConnection();
            String q="delete from employee where id =1";
            Statement statement=connection.createStatement();
            statement.execute(q);


    }
    public static void main(String[] args) throws SQLException {
        if (getConnection()!=null) System.out.println("ss");
        else System.out.println("");

        getEmp();
        delEmp();
    }
}
// statement: kem an toan
// prepareStatement: An toan cho truyen tham so dau vao --> dung cho cac truong hop bat buoc co tham so nguoi dung
// Callable: su dung procedure va ham trong sql
//SQl injection loi xay ra voi sql khi thuc hien ket noi sql voi cac app
