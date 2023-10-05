public class Test {
    public static void main(String[] args) throws InterruptedException {
        MultiThreadvsThread mt=new MultiThreadvsThread();
        mt.start();

        MultiThreadRunnale multiThreadRunnale=new MultiThreadRunnale();
        Thread thread=new Thread(multiThreadRunnale);
        thread.start();
        thread.join(2000);// khi hoan thanh nv trong 2000 ms  thi
        // cac luong khac moi bat dau thuc hien
        //join cho 1 luong ket thuc
        // lam cho cac luong khac dang chay ngung hoat dong cho den khi luong ma no tham gia hoan thanh
        //nhiem vu. Bat buoc phai throw InterruptedException

        // run(): thuc hien hanh dong luong
        // start(): bat dau thuc thi
        // sleep(): tam ngung trong bao lau
        // interupt(): check luong ket thuc. Ngat luong-> gian doan thread
    }
}
