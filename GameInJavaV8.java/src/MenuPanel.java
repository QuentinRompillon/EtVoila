import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    
    private final MainFrame mainFrame;
    private Image backgroundImage;
    public Text text;
    public Audio audioplayer;

    public MenuPanel(MainFrame mainFrame) {

        this.mainFrame = mainFrame;
        backgroundImage = new ImageIcon(getClass().getResource("/img/back1.png")).getImage();
        text = new Text();
        setLayout(null);
        new SetImages();
        
        audioplayer = new Audio();
        restartMusic();

        displayMenuButton();
    }

    public void restartMusic() {
        if (audioplayer != null) {
            audioplayer.PlayMusic(2);
        }
    }

    public void stopMusic() {
        if (audioplayer != null) {
            audioplayer.StopMusic();
        }
    }

    public void displayMenuButton() {

        JButton bouton1 = CreateButton.create(text.play.get(MainFrame.language), -200, 0.35);
        JButton bouton2 = CreateButton.create(text.topscores.get(MainFrame.language), 20, 0.35);
        JButton bouton3 = CreateButton.create(text.language.get(MainFrame.language), -200, 0.425);
        JButton bouton4 = CreateButton.create(text.about.get(MainFrame.language), 20, 0.425);
        JButton bouton5 = CreateButton.create(text.leave.get(MainFrame.language), -90, 0.50);

        bouton1.addActionListener(_ -> mainFrame.showMapChoicePanel());
        bouton2.addActionListener(_ -> mainFrame.showTopscoresPanel());
        bouton3.addActionListener(_ -> mainFrame.showLanguagePanel());
        bouton5.addActionListener(_ -> System.exit(0));

        add(bouton1);
        add(bouton2);
        add(bouton3);
        add(bouton4);
        add(bouton5);
    }

    public void updateLanguage() {
        removeAll(); 
        text = new Text(); 
        displayMenuButton(); 
        revalidate();
        repaint(); 
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(SetImages.endText, (DataBase.panelsWidth / 2) - 245 , (DataBase.panelsHeight / 6) - 61, null);

    }
}
