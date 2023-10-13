package txtfile;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadWriteFile {
    public void readFile() {
        try {

            FileInputStream inputStream = new FileInputStream("text.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            int i;
            while ((i = bufferedInputStream.read()) != -1) {
                System.out.print((char) i);
            }


            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            File file = new File("text.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String s) {
        byte[] b=s.getBytes();
        try {
            FileOutputStream fos = new FileOutputStream("text.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            bos.write(b);
            bos.flush();
            bos.close();
        } catch (FileNotFoundException e) {
            File file = new File("text.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
