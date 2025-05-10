import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    
    private final MainFrame mainFrame;
    public Text text;
    public Image backgroundImage;
    public Audio audioplayer;

    public MenuPanel(MainFrame mainFrame) {

        this.mainFrame = mainFrame;

        setLayout(null);
        backgroundImage = new ImageIcon("src/img/backgroundimage.jpg").getImage();
        text = new Text();
        //audioplayer = new Audio();
        //audioplayer.PlayMusic(1);

        displayMenuButton();
    }

    public void displayMenuButton() {

        JButton bouton1 = CreateButton.create(text.play.get(MainFrame.language), -180, 0.3);
        JButton bouton2 = CreateButton.create(text.topscores.get(MainFrame.language), 20, 0.3);
        JButton bouton3 = CreateButton.create(text.language.get(MainFrame.language), -180, 0.4);
        JButton bouton4 = CreateButton.create(text.about.get(MainFrame.language), 20, 0.4);
        JButton bouton5 = CreateButton.create(text.leave.get(MainFrame.language), -80, 0.5);

        bouton1.addActionListener(_ -> mainFrame.showGamePanel());
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
    }
}
