package Controller;

import modal.Book;
import service.LibraryService;

import java.sql.SQLException;
import java.util.Scanner;

public class Controller {
    LibraryService libraryService=new LibraryService();
    Scanner scanner=new Scanner(System.in);
    public void addBook() throws SQLException {
        Book book=new Book();
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
        int code=scanner.nextInt();
        scanner.nextLine();
        Book book=libraryService.searchByCode(code);
        System.out.println(book);
    }
    public void searchByName() throws SQLException {
        System.out.println("input book name:");
        String name=scanner.nextLine();

        Book book=libraryService.searchByName(name);
        System.out.println(book);
    }
    public void borrow() throws SQLException {
        System.out.println("book code");
        int code=scanner.nextInt();
        Book book=libraryService.searchByCode(code);
        System.out.println(book);
        System.out.println("Borrow quantity");
        int quan=scanner.nextInt();
        scanner.nextLine();
        if (quan>book.getQuantity()) {
            System.out.println("Book's quantity is smaller than "+quan);

        }
        else {
            String s = libraryService.borrow(code, quan);
            System.out.println(s);
        }
    }
    public void view() throws SQLException {
        System.out.println(libraryService.viewBook());
    }
    public void lend() throws SQLException {
        System.out.println("book code");
        int code=scanner.nextInt();
        Book book=libraryService.searchByCode(code);
        System.out.println(book);
        scanner.nextLine();
            String s = libraryService.lend(code);
            System.out.println(s);

    }
}
