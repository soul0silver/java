import controller.LoginController;
import view.LoginConsole;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        LoginConsole console=new LoginConsole();
        console.menu();

    }
}
