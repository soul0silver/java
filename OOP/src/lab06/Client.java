package lab06;

public class Client {
    public Client() {
    }
    public void doUnChecked(String value){
        System.out.println(canThrowUncheckedException(value));
    }
    public int canThrowUncheckedException(String value){
        return Integer.parseInt(value);
    }
    public void doChecked() {
        try {
            // Buoc phai check exceptions o day! Khong cach nao khac

            canThrowCheckedException();
            System.out.println("OK");
        }catch(Exception ex) {
            System.out.println(ex);
        }
    }

    private int canThrowCheckedException() throws Exception {
        throw new Exception("Failure");
    }
    public static void cc(){}
}
