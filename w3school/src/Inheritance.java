import java.util.Scanner;

public class Inheritance extends Person{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Inheritance inheritance=new Inheritance();
        inheritance.setName(sc.next());
        System.out.println(inheritance.getName());
    }
}
