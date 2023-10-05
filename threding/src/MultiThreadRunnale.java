public class MultiThreadRunnale implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {

        try {
            Thread.sleep(1000);
            System.out.println(i);
        }catch (InterruptedException e){
            System.out.println(e);
        }}
        System.out.println("done");

    }
}
