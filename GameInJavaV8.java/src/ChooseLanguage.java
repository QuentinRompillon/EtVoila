import javax.swing.*;
import java.awt.*;

public class ChooseLanguage extends JPanel {

    private int panelWidth = DataBase.panelOneWidth;
    private int panelHeight = DataBase.panelOneHeight;
    private int panelMiddleAxis = DataBase.panelOneMiddleAxis;

    public Image backgroundImage;
    public Text text;

    public ChooseLanguage(MainFrame mainFrame) {

        text = new Text();
        backgroundImage = new ImageIcon(getClass().getResource("/img/back1.png")).getImage();
        setLayout(new GridBagLayout()); // Pour centrer le sous-panel

        GridBagConstraints gbc = CreateGridBagConstraints.create();
        JPanel contentPanel = CreatePanel.create(panelWidth, panelHeight, Color.black, Color.lightGray, 1, true);
        
        JTextArea textarea = CreateTextArea.create(text.choosealanguage.get(MainFrame.language), Color.black, Color.white, 20, panelMiddleAxis, 40, true);
        JButton englishBtn = CreateButton.create(text.english.get(MainFrame.language), -200 - ((DataBase.panelsWidth - panelWidth) / 2), 0.3);
        JButton frenchBtn = CreateButton.create(text.french.get(MainFrame.language), 20 - ((DataBase.panelsWidth - panelWidth) / 2), 0.3);
        JButton backtomenuBtn = CreateButton.create(text.backtomenu.get(MainFrame.language),-90 - ((DataBase.panelsWidth - panelWidth) / 2), 0.6);
        
        englishBtn.addActionListener(_ -> {
            MainFrame.language = 0;
            mainFrame.showLanguagePanel();
        });
        frenchBtn.addActionListener(_ -> {
            MainFrame.language = 1;
            mainFrame.showLanguagePanel();
        });
        backtomenuBtn.addActionListener(_ -> mainFrame.showMenuPanel());

        contentPanel.add(textarea);
        contentPanel.add(englishBtn);
        contentPanel.add(frenchBtn);
        contentPanel.add(backtomenuBtn);   

        add(contentPanel, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
