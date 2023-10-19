package controller;

import model.User;
import service.UserSv;
import service.imp.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginController implements EmployeeDAO {
    UserSv userSv=new UserService();
    Scanner scanner=new Scanner(System.in);
    @Override
    public void create() throws SQLException {
        User user =new User();
        System.out.println("New Employee");
        int re=-1;
        try {
            System.out.println("Input username");
            user.setUsername(scanner.nextLine());
            System.out.println("Input password");
            user.setPassword(scanner.nextLine());
            re=userSv.create(user);
        }catch (Exception e){
            System.out.println("Value not invalid");
        }
        if (re==1) System.out.println("create ss");
        else System.out.println("create fail");;
        System.out.println();
    }

    @Override
    public String login() throws SQLException {
        System.out.println("Input username");
       String un=(scanner.nextLine());
        System.out.println("Input password");
        String pass=(scanner.nextLine());
        return userSv.login(un,pass);
    }


}
