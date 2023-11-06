import Controller.Controller;

import java.sql.SQLException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws SQLException {
        boolean flag=false;
        Controller controller=new Controller();
        Scanner scanner=new Scanner(System.in);
        while (!flag){
            System.out.println("1. add Book");
            System.out.println("2. search by code");
            System.out.println("3. search by name");
            System.out.println("4. view all");
            System.out.println("5. borrow");
            System.out.println("6. exit");
            System.out.println("your choice:");
            int ch=scanner.nextInt();
            scanner.nextLine();
            switch (ch){
                case 1:controller.addBook();break;
                case 2:controller.searchByCode();break;
                case 3:controller.searchByName();break;
                case 4:controller.view();break;
                case 5:controller.borrow();break;
                case 6:System.exit(0);break;
                default:
                    System.out.println("Wrong select");
            }
        }

    }
}
