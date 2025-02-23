import service.MainService;
import winodow.ConsoleWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConsoleWindow console = new ConsoleWindow();
            MainService mainService = new MainService(console);
            console.setMainService(mainService);
            console.setVisible(true);
        });
    }
}




