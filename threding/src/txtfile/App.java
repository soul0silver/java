package txtfile;

public class App {

    public static void main(String[] args) {
        ReadWriteFile file=new ReadWriteFile();
        file.readFile();
        file.write("dat");
    }
}
