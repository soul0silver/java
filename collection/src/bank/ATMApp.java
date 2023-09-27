package bank;

import java.io.IOException;

public class ATMApp {
    public static void main(String[] args) throws IOException {
        Menu menu=new Menu();
        System.out.println("Welcome to th ATM Application");
        menu.start();
        menu.mainMenu();
    }
}
