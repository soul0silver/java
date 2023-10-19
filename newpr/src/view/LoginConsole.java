package view;

import controller.LoginController;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginConsole {
    LoginController controller=new LoginController();
    Scanner scanner = new Scanner(System.in);

    public void menu() throws SQLException {
        while (true) {
            System.out.println("1. create");
            System.out.println("2. login");
            System.out.println("3. Exit");

            System.out.println("Your choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine();
            switch (ch) {
                case 1:
                    controller.create();
                    break;
                case 2:
                    controller.login();
                    break;

                case 3:
                    System.exit(0);
                default:
                    System.out.println("wrong choice");
            }
        }
    }
}
