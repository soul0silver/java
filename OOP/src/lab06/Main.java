package lab06;

import static lab06.Client.cc;

public class Main {
    public static void main(String[] args) {
        Client client=new Client();
        client.doUnChecked("12");
        cc();
        client.doChecked();
    }
}
