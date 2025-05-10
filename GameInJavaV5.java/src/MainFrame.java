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
        LoadingScreen loadingScreen = new LoadingScreen(this);
        cards.add(loadingScreen, "loadingscreen");

        add(cards);

        // Afficher immédiatement le LoadingScreen
        cardLayout.show(cards, "loadingscreen");

        // S'assurer que la fenêtre est visible après tout l'ajout
        setVisible(true);
    }

    public void showLanguagePanel() {
        ChooseLanguage cl = new ChooseLanguage(this);
        cards.add(cl, "language");
        cardLayout.show(cards, "language");
    }

    public void showTopscoresPanel() {
        TopScores topScores = new TopScores(this);
        cards.add(topScores, "topscores");
        cardLayout.show(cards, "topscores");
    }

    public void showGamePanel() {
        ChromeDinosaur chromeDinosaur = new ChromeDinosaur(this);
        cards.add(chromeDinosaur, "game");
        cardLayout.show(cards, "game");
        chromeDinosaur.requestFocus();
    }

    public void showMenuPanel() {
        MenuPanel menuPanel = new MenuPanel(this);
        menuPanel.updateLanguage(); // <-- mise à jour avant affichage
        cards.add(menuPanel, "menu");
        cardLayout.show(cards, "menu");
    }
}
