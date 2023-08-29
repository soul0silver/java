public class Contructor {
    int x;

    // Create a class constructor for the Main class
    public Contructor() {
        x = 5;
    }

    public static void main(String[] args) {
        Contructor myObj = new Contructor();
        System.out.println(myObj.x);
    }
}
