package AptechBank;

import java.sql.SQLException;
import java.util.Scanner;

public class Controller {
    Menu menu=new Menu();
    Repo repo=new Repo();
    public void createTb() throws SQLException {
        repo.createTB();
    }
    public void createCus() throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input name:");
        String name=sc.nextLine();
        System.out.println("Input id:");
        int id=sc.nextInt();
        sc.nextLine();
        repo.createCus(name,id);

    }
    public void update() throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input name:");
        String name=sc.nextLine();
        System.out.println("Input id:");
        int id=sc.nextInt();
        sc.nextLine();
        repo.updateCus(name,id);
    }
    public void  del() throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input name:");
        int id= sc.nextInt();
        sc.nextLine();
        String name= sc.nextLine();
        Customer customer=new Customer(id,name);
        repo.delCus(customer);
    }
    public void find() throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input id:");
        int id=sc.nextInt();
        sc.nextLine();
        Customer customer= repo.find(id);
        System.out.println(customer);
    }
    public  void display() throws SQLException {
        repo.displayAll();
    }

}
