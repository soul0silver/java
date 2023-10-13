package workshop;

import java.io.*;

public class FileReader {
    public static void readFile(){
        try {
            FileInputStream inputStream=new FileInputStream("workshop.txt");
            BufferedInputStream bis=new BufferedInputStream(inputStream);
            int i;
            String res="";
            while ((i=bis.read())!=-1){
                System.out.print((char) i);
                res+=(char)(i+1);

            }
            System.out.println();
            write(res);
            System.out.println(res);
            bis.close();
        } catch (FileNotFoundException e) {
            File file=new File("workshop.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void write(String s){
        try {
            FileOutputStream outputStream=new FileOutputStream("workshop.txt");
            BufferedOutputStream bos=new BufferedOutputStream(outputStream);
            bos.write(s.getBytes());
            bos.flush();
            bos .close();
        } catch (FileNotFoundException e) {
            File file=new File("workshop.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        write("bcde");
        readFile();
    }
}
