import javax.swing.*;

public class Main {

    public static int widthWindow = 1200;
    public static int heightWindow = 600;

    public static void main(String[] args) {

        MenuPanel menuPanel = new MenuPanel();
        menuPanel.displayMenuPanel();
        menuPanel.displayMenuButton();

        JFrame frame = new JFrame("Pas encore de nom");

        frame.setSize(widthWindow,heightWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setContentPane(menuPanel);
        frame.setVisible(true);

        //Audio audioplayer = new Audio();
        //audioplayer.PlayMusic("src/Music.wav");

    }
}


