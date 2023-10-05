package lab1_jp2.ex2;

public class Workshop {
    public static void main(String[] args) {
        Person[] person=new Person[3];
        person[0]=new Person("A",4);
        person[1]=new Person("B",4);
        person[2]=new Person("C",4);

        for (int i = 0; i < 3; i++) {
            person[i].start();
        }
    }
}
