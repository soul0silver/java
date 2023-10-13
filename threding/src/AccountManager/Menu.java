package AccountManager;

public class Menu {
    public static void mainMenu() {
        System.out.println("Your select");
        System.out.println("1. Login");
        System.out.println("2. Sign");
        System.out.println("your choice");

    }

    public static void loginFail() {
        System.out.println("wrong password...");
        System.out.println("1. Re-Login");
        System.out.println("2. Forgot password");
        System.out.println("Your choice: ");
    }

    public static void loginSuccess() {
        System.out.println("1. Change username");
        System.out.println("2. Change email");
        System.out.println("3. Change password");
        System.out.println("4. Log out");
        System.out.println("5. Exit");
        System.out.println("Your Choice: ");
    }
}
