package AccountManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Controller {
    String username;
    String password;
    public Controller() throws IOException {
    }
    Repository repository=new Repository();
    Scanner scanner=new Scanner((System.in));
    List<User> users=repository.read();

    public void home(){
        Menu.mainMenu();
        int choice=scanner.nextInt();
        scanner.nextLine();
        switch (choice){
            case 1:login();break;
            case 2:create();break;
            default:
        }
    }
    public void login(){
        boolean flag=false;
        while (!flag){
            System.out.println("Username");
            username=scanner.nextLine();
            int count=0;
            for (int i = 0; i < users.size(); i++) {
                if (username.equals(users.get(i).getUsername())) {
                    count++;
                    System.out.println("Password");
                    password=scanner.nextLine();
                    if (password.equals(users.get(i).getPassword())) {
                        flag = true;
                        success();
                        break;
                    }
                    else {
                        fail();
                        break;
                    }
                }
                System.out.println();

            }
            if (count==0) System.out.println("Wrong username");
        }
    }
    public void  create(){}
    public void success(){
        System.out.println("welcome "+username);
        Menu.loginSuccess();
    }
    public void  fail(){
        System.out.println("login fail");
        Menu.loginFail();
        int ch=scanner.nextInt();
        scanner.nextLine();
    }
    public void forgotPass(){}
}
