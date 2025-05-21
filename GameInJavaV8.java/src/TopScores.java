import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TopScores extends JPanel implements KeyListener{

    private int panelWidth = DataBase.panelOneWidth;
    private int panelHeight = DataBase.panelOneHeight;
    private int panelMiddleAxis = DataBase.panelOneMiddleAxis;

    public Text text;
    public Image backgroundImage;
    private MainFrame mainFrame;

    public static int[] topscores = new int[7];
    
    public TopScores(MainFrame mainFrame) {  

        this.mainFrame = mainFrame;
        text = new Text();
        if (DataBase.currentPanel == 0) {
            backgroundImage = new ImageIcon(getClass().getResource("/img/back1.png")).getImage();
        }
        else if (DataBase.currentPanel == 1) {
            backgroundImage = new ImageIcon(getClass().getResource("/img/backgame1.jpg")).getImage();
        }
        setLayout(new GridBagLayout()); //to center the panel
        setFocusable(true);
        addKeyListener(this);

        GridBagConstraints gbc = CreateGridBagConstraints.create();
        JPanel contentPanel = CreatePanel.create(panelWidth, panelHeight, Color.black, Color.lightGray, 1, true);


        int ypositionTitre = 45;
        int ypositionScore1 = ypositionTitre + 100;
        int xpositionScores = panelMiddleAxis - 150;
        int espacementScores = 28;
        int textSize = 19;

        JTextArea textarea1 = CreateTextArea.create(text.top7scores.get(MainFrame.language), Color.black, Color.white, 20, panelMiddleAxis, ypositionTitre, true);
        JTextArea textareascore1 = CreateTextArea.create(text.first.get(MainFrame.language) + topscores[0] + "%", Color.black, Color.decode("#ece625"), textSize, xpositionScores, ypositionScore1, false);
        JTextArea textareascore2 = CreateTextArea.create(text.second.get(MainFrame.language) + topscores[1] + "%", Color.black, Color.decode("#d2d3c8"), textSize, xpositionScores, ypositionScore1 + espacementScores*1, false);
        JTextArea textareascore3 = CreateTextArea.create(text.third.get(MainFrame.language) + topscores[2] + "%", Color.black, Color.decode("#ecb65e"), textSize, xpositionScores, ypositionScore1 + espacementScores*2, false);
        JTextArea textareascore4 = CreateTextArea.create(text.fourth.get(MainFrame.language) + topscores[3] + "%", Color.black, Color.white, textSize, xpositionScores, ypositionScore1 + espacementScores*3, false);
        JTextArea textareascore5 = CreateTextArea.create(text.fifth.get(MainFrame.language) + topscores[4] + "%", Color.black, Color.white, textSize, xpositionScores, ypositionScore1 + espacementScores*4, false);
        JTextArea textareascore6 = CreateTextArea.create(text.sixth.get(MainFrame.language) + topscores[5] + "%", Color.black, Color.white, textSize, xpositionScores, ypositionScore1 + espacementScores*5, false);
        JTextArea textareascore7 = CreateTextArea.create(text.seventh.get(MainFrame.language) + topscores[6] + "%", Color.black, Color.white, textSize, xpositionScores, ypositionScore1 + espacementScores*6, false);

        JButton backtomenuBtn = CreateButton.create(text.backtomenu.get(MainFrame.language),-90 - ((DataBase.mainFrameWidth - panelWidth) / 2), 0.6);
        backtomenuBtn.addActionListener(_ -> mainFrame.showMenuPanel());

        contentPanel.add(textarea1);
        contentPanel.add(textareascore1);
        contentPanel.add(textareascore2);
        contentPanel.add(textareascore3);
        contentPanel.add(textareascore4);
        contentPanel.add(textareascore5);
        contentPanel.add(textareascore6);
        contentPanel.add(textareascore7);
        contentPanel.add(backtomenuBtn);

        add(contentPanel, gbc);
    }


    public static void addnewscore(int newscore) {
        int place = 0;
        Arrays.sort(topscores);
        
        for (int i = 0; i < topscores.length / 2; i++) {
            int temp = topscores[i];
            topscores[i] = topscores[topscores.length - 1 - i];
            topscores[topscores.length - 1 - i] = temp;
        }
        //check if the new score can be in the top 
        if(newscore > topscores[topscores.length - 1]) {
            for(int i = topscores.length - 1; i >= 0; i--) {
                if(newscore > topscores[i]) {
                    place = i;
                }
            }
            //add the score in the array
            for(int j  = topscores.length - 1; j > place; j--) {
                topscores[j] = topscores[j-1];
            }
            topscores[place] = newscore;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_T) {
            mainFrame.showMapGamePanel();
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
