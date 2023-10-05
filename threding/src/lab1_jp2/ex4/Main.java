package lab1_jp2.ex4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MThread[] threads = new MThread[3];
        threads[0] = new MThread("First", 5);
        threads[1] = new MThread("Second", 5);
        threads[2] = new MThread("Third", 5);

        for (int i = 0; i < 3; i++) {
            threads[i].start();
            threads[i].join(1000);
        }
    }
}
