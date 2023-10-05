package lab1_jp2.ex4;

public class MThread extends Thread{
    String name;
    int number;

    public MThread(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = number; i >=1; i--) {
            if (i==1){
                System.out.printf("%s : %d \n",name,i);
                System.out.printf("%s : exiting \n",name);}
            else System.out.printf("%s : %d \n",name,i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
