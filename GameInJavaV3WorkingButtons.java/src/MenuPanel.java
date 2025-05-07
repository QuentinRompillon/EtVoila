import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel{

    private static int widthMenuPanel = Main.widthWindow;
    private static int heightMenuPanel = Main.heightWindow;
    private Text text;
    private static int language = 0; // 0 -> english, 1 -> french

    private Image backgroundImage;

    public MenuPanel() {
        text = new Text();
        setLayout(null);
        backgroundImage = new ImageIcon("src/backgroundimage.jpg").getImage();
    }

    public void displayMenuPanel() {

        setPreferredSize(new Dimension(widthMenuPanel, heightMenuPanel));
        repaint();
    }
    
    public void displayMenuButton() {

        JButton bouton1 = createButton(text.play.get(language), -180, 0.3);
        JButton bouton2 = createButton(text.topscores.get(language), 20, 0.3);
        JButton bouton3 = createButton(text.language.get(language), -180, 0.4);
        JButton bouton4 = createButton(text.about.get(language), 20, 0.4);
        JButton bouton5 = createButton(text.leave.get(language),-80, 0.5);

        bouton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(language == 0){
                    language = 1;
                }
                else if(language == 1){
                    language = 0;
                }
                removeAll();
                repaint();
                displayMenuButton();
                revalidate();
            }
        });

        bouton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(bouton1);
        add(bouton2);
        add(bouton3);
        add(bouton4);
        add(bouton5);

        }

    private JButton createButton(String text, double middleposition, double positionFactor) {

        JButton button = new JButton(text);
        int xPosition = (int) ((Main.widthWindow / 2) + middleposition);
        int yPosition = (int) (heightMenuPanel * positionFactor);
        button.setBounds(xPosition,yPosition,160,40);
        button.setBackground(Color.decode("#120228"));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        return button;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
