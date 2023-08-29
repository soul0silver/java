import java.util.Scanner;

public class Bai35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        if(a.equals(b)) {
            System.out.println("A is equal to B");
        }
        if (a == b) {
            System.out.println("A == B");
        }
    }
}
