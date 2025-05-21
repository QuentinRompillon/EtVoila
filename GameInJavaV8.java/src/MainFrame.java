import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static int language = 0; // 0 -> english, 1 -> french
    private CardLayout cardLayout;
    private MenuPanel menuPanel;
    private JPanel cards;

    public MainFrame() {
        setTitle("Et Voilà !");
        setSize(DataBase.mainFrameWidth, DataBase.mainFrameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        menuPanel = new MenuPanel(this);
        cards.add(menuPanel, "menu");

        add(cards);
        cardLayout.show(cards, "menu");
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
        topScores.requestFocus();
    }

    public void showMapGamePanel() {
        DataBase.currentPanel = 1;
        GameMap gameMap = new GameMap(this);
        menuPanel.stopMusic();
        Audio.menuMusicPlayed = false;
        cards.add(gameMap, "game");
        cardLayout.show(cards, "game");
        gameMap.requestFocus();
    }

    public void showMenuPanel() {
        DataBase.currentPanel = 0;
        menuPanel.updateLanguage();
        if (!Audio.menuMusicPlayed) {
            menuPanel.restartMusic();
        }
        cardLayout.show(cards, "menu");
    }

    public void showMapChoicePanel() {
        MapChoice mapChoice = new MapChoice(this);
        cards.add(mapChoice, "mapchoice");
        cardLayout.show(cards, "mapchoice");
        mapChoice.requestFocus();
    }
}
