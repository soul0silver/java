package lab1_jp2.ex3;

public class Test {
    public static void main(String[] args) {
        MyThread myThread=new MyThread("MyThread");

        System.out.println(myThread.getName());
        myThread.setName("MyJavaThread");
        System.out.println(myThread.getName());
        System.out.println("Run");
        myThread.start();
    }
}
