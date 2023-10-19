package service;

import model.User;

import java.sql.SQLException;

public interface UserSv {
    public int create(User employee) throws SQLException;
    public String login(String username, String password) throws SQLException;

}
