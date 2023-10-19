package controller;


import java.sql.SQLException;

public interface EmployeeDAO {
    public void create() throws SQLException;
    public String login() throws SQLException;

}
