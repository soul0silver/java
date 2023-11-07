package Controller;

import modal.Book;
import modal.Ticket;
import modal.TicketDetails;
import service.LibraryService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Controller {
    LibraryService libraryService = new LibraryService();
    Scanner scanner = new Scanner(System.in);

    public void addBook() throws SQLException {
        Book book = new Book();
        System.out.println("name");
        book.setName(scanner.nextLine());
        System.out.println("author");
        book.setAuth(scanner.nextLine());
        System.out.println("quantity");
        book.setQuantity(scanner.nextInt());
        scanner.nextLine();
        libraryService.addBook(book);
    }

    public void searchByCode() throws SQLException {
        System.out.println("input code:");
        int code = scanner.nextInt();
        scanner.nextLine();
        Book book = libraryService.searchByCode(code);
        System.out.println(book);
    }

    public void searchByName() throws SQLException {
        System.out.println("input book name:");
        String name = scanner.nextLine();

        Book book = libraryService.searchByName(name);
        System.out.println(book);
    }

    public void borrow() throws SQLException {
        List<Book> list = new ArrayList<>();
        System.out.println("Student id");
        int sid = scanner.nextInt();
        scanner.nextLine();
        Ticket ticket=new Ticket();
        ticket.setSid(sid);
        ticket.setDateBorrow(new Date().toString());
        boolean flag=false;
        while (!flag) {
            view();
            System.out.println("book code");
            int code = scanner.nextInt();
            Book book = libraryService.searchByCode(code);

            System.out.println("Borrow quantity");
            int quan = scanner.nextInt();
            scanner.nextLine();
            if (libraryService.checkQuan(code,quan)){
                book.setQuantity(quan);
                list.add(book);
            } else System.out.println("Book's quantity is smaller than you want");
            System.out.println("Continue borrow ?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int ch=scanner.nextInt();
            scanner.nextLine();
            if (ch==1) flag=false;
            else if (ch==2) flag=true;
        }
        libraryService.borrow(list,ticket);

    }

    public void view() throws SQLException {
        System.out.println(libraryService.viewBook());
    }

    public void lend() throws SQLException {
        System.out.println("Show student id");
        int code = scanner.nextInt();
        List<Ticket> list=libraryService.searchTicket(code);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("ticket "+(i+1)+list.get(i).toString());
        }

        System.out.println("select ticket");
        int ch=scanner.nextInt();
        Ticket ticket=list.get(ch-1);
        scanner.nextLine();
        String s = libraryService.lend(ticket);
        System.out.println(s);

    }
}
