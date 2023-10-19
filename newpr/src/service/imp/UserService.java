package service.imp;

import model.User;
import repository.UserRepo;
import service.UserSv;

import java.sql.SQLException;

public class UserService implements UserSv {
    UserRepo userRepo=new UserRepo();


    @Override
    public int create(User user) throws SQLException {
        return userRepo.create(user);
    }

    @Override
    public String login(String username, String password) throws SQLException {
        return userRepo.checkLogin(username,password);
    }
}
