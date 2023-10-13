package AptechBank;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
        Menu menu=new Menu();
        Controller controller=new Controller();
//        controller.createTb();
        while (true) {
            menu.menu();
            System.out.println("Your choice: ");
            Scanner sc = new Scanner(System.in);
            switch (sc.nextInt()){
                case 1:controller.createCus();break;
                case 2:controller.update();break;
                case 3:controller.del();break;
                case 4:controller.find();break;
                case 5:controller.display();
                case 6:System.exit(0);
                default:
                    System.out.println("wrong choice");
            }
        }
    }
}
