package lab02.Lab02_1;

public class Client {
    public static void main(String[] args) {
        Student studentA;
        Student studentB;
        studentA=new Student();
        studentB=new Student(1,"Nguyen Van A",true);

        studentB.printInfo();

        studentB.setName("Nguyen Van B");
        studentB.printInfo();


    }
}
