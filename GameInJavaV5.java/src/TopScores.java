import java.util.Arrays;
import javax.swing.*;
import java.awt.*;

public class TopScores extends JPanel {

    private static final int widthOverlayPanel = (int) (0.8 * MainFrame.windowWidth);
    private static final int heightOverlayPanel = (int) (0.8 * MainFrame.windowHeight);

    public Text text;

    public static int[] topscores = new int[5];
    

    public TopScores(MainFrame mainFrame) {  
        text = new Text();
        
        setBackground(Color.decode("#120228"));
        setLayout(new GridBagLayout()); // Pour centrer le sous-panel

        JPanel contentPanel = new JPanel(null);
        contentPanel.setPreferredSize(new Dimension(widthOverlayPanel, heightOverlayPanel));
        contentPanel.setBackground(Color.decode("#2e5ccd"));
        contentPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true)); // bordure douce

        JLabel label = new JLabel("Top scores :");
        label.setForeground(Color.WHITE);
        label.setBounds(30, 30, 200, 30);
        contentPanel.add(label);

        JTextArea textArea = new JTextArea();
        textArea.setText("Score 1 : " + topscores[0] + "\nScore 2 : " + topscores[1] + "\nScore 3 : " + topscores[2] + "\nScore 4 : " + topscores[3] + "\nScore 5 : " + topscores[4]);
        textArea.setEditable(false);
        textArea.setBackground(Color.decode("#2e5ccd")); // même fond que le panel
        textArea.setForeground(Color.WHITE); // texte visible
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setBounds(30, 70, 300, 100); // POSITION + TAILLE !!
        contentPanel.add(textArea);


        JButton backBtn = CreateButton.create(text.back.get(MainFrame.language),0, 0.4);
        backBtn.addActionListener(_ -> mainFrame.showMenuPanel());
        contentPanel.add(backBtn);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        add(contentPanel, gbc);

    }

    public static void addnewscore(int newscore) {
        int place = 0;
        // trier le tableau des scores
        Arrays.sort(topscores);
        
        for (int i = 0; i < topscores.length / 2; i++) {
            int temp = topscores[i];
            topscores[i] = topscores[topscores.length - 1 - i];
            topscores[topscores.length - 1 - i] = temp;
        }

        //vérifier si le nouveau score peut rentrer dans le tableau
        if(newscore > topscores[4]) {
            for(int i = topscores.length - 1; i >= 0; i--) {
                if(newscore > topscores[i]) {
                    place = i;
                }
            }
            // réorganiser le tableau selon le nouveau score
            for(int j  = topscores.length - 1; j > place; j--) {
                topscores[j] = topscores[j-1];
            }
            topscores[place] = newscore;
        }
    }

    public static void displaytopscores() {
        for(int i = 0; i < topscores.length; i++) {
            if(topscores[i] != 0) {
                System.out.println(topscores[i]);
            }
        }
    }
}
