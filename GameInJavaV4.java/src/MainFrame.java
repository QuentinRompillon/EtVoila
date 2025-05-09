import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static int language = 0; // 0 -> english, 1 -> french

    private CardLayout cardLayout;
    private JPanel cards;
    public static int windowWidth = 1200;
    public static int windowHeight = 600;

    public MainFrame() {

        setTitle("Et Voilà !");
        setSize(windowWidth, windowHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        // Création des panels
        MenuPanel menuPanel = new MenuPanel(this);
        cards.add(menuPanel, "menu");

        add(cards);
        setVisible(true);
    }

    public void showLanguagePanel() {
        ChooseLanguage cl = new ChooseLanguage(this);
        cards.add(cl, "language");
        cardLayout.show(cards, "language");
    }

    public void showGamePanel() {
        ChromeDinosaur cd = new ChromeDinosaur();
        cards.add(cd, "game");
        cardLayout.show(cards, "game");
    }

    public void showMenuPanel() {
        cardLayout.show(cards, "menu");
    }
}
