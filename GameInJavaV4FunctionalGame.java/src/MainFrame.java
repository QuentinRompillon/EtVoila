import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static int language = 0; // 0 -> english, 1 -> french
    private MenuPanel menuPanel;
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
        menuPanel = new MenuPanel(this);
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
        ChromeDinosaur chromeDinosaur = new ChromeDinosaur(this);
        cards.add(chromeDinosaur, "game");
        cardLayout.show(cards, "game");
        chromeDinosaur.requestFocus();
         
    }

    public void showMenuPanel() {
        menuPanel.updateLanguage(); // <-- mise à jour avant affichage
        cardLayout.show(cards, "menu");
    }
}
