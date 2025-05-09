import javax.swing.*;
import java.awt.*;

public class ChooseLanguage extends JPanel {

    // taille du panel
    private static final int widthOverlayPanel = (int) (0.8 * MainFrame.windowWidth);
    private static final int heightOverlayPanel = (int) (0.8 * MainFrame.windowHeight);

    //pour avoir à Text
    public Text text;

    public ChooseLanguage(MainFrame mainFrame) {

        text = new Text();
        
        setBackground(Color.decode("#120228"));
        setLayout(new GridBagLayout()); // Pour centrer le sous-panel


        // sous panel
        JPanel contentPanel = new JPanel(null);
        contentPanel.setPreferredSize(new Dimension(widthOverlayPanel, heightOverlayPanel));
        contentPanel.setBackground(Color.decode("#2e5ccd"));
        contentPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true)); // bordure douce

        // texte
        JLabel label = new JLabel("Choose a language:");
        label.setForeground(Color.WHITE);
        label.setBounds(30, 30, 200, 30);
        contentPanel.add(label);

        // Boutons 
        JButton englishBtn = CreateButton.create(text.english.get(MainFrame.language), -180, 0.3);
        JButton frenchBtn = CreateButton.create(text.french.get(MainFrame.language), 20, 0.3);
        JButton backBtn = CreateButton.create(text.back.get(MainFrame.language),0, 0.4);
        
        englishBtn.addActionListener(_ -> {
            MainFrame.language = 0;
            mainFrame.showLanguagePanel();
        });
        frenchBtn.addActionListener(_ -> {
            MainFrame.language = 1;
            mainFrame.showLanguagePanel();
        });
        backBtn.addActionListener(_ -> mainFrame.showMenuPanel());

        contentPanel.add(englishBtn);
        contentPanel.add(frenchBtn);
        contentPanel.add(backBtn);   

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        add(contentPanel, gbc);
    }
}
