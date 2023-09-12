package lab06;

import java.util.InputMismatchException;

public class UncheckedEx {
    public UncheckedEx() {
    }

    public static void main(String[] args){
            int i, n = 2;int k;
            int a[] = new int[n];
            try {
            //Declare Scanner Object named input


            for(i=0; i<=n; i++)
            {
                java.util.Scanner input = new java.util.Scanner(System.in);
                try {
                    System.out.printf("a[%d] = ", i);
                    a[i] = input.nextInt();
                    input.nextLine();
                }
                catch (InputMismatchException e){
                    System.out.println("must be number");
                    i--;
                }
            }
        }
            catch (IndexOutOfBoundsException e){
                System.out.println("Index 2 out of bounds for length 2");
            }

    }

}
