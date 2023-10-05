package lab1_jp2.ex2;

public class Person extends Thread{
    String name;
    int talk;

    public Person(String name, int talk) {

        this.name = name;
        this.talk = talk;
    }

    @Override
    public void run() {
        for (int i = 0; i < talk; i++) {
            System.out.println(name+": " +i+ " talking");

            try {
                Thread.sleep(Math.round (Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("conclude");
        }
    }
}
