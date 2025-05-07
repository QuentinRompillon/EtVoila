import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameWindow {

    private static int widthWindow = 1200;
    private static int heightWindow = 600;
    private static int widthOverlayPanel = widthWindow;
    private static int heightOverlayPanel = heightWindow;
    private static int widthGamePanel = (int) (0.8 * widthWindow);
    private static int heightGamePanel = (int) (0.8 * heightWindow);

    public static void main(String[] args) {

        JFrame frame = new JFrame("Univers");

        frame.setSize(widthWindow,heightWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(widthWindow,heightWindow));

        // Panel à l'arrière plan
        OverlayPanel OverlayPanel = new OverlayPanel();
        OverlayPanel.setBounds(0,0,widthOverlayPanel,heightOverlayPanel);
        OverlayPanel.setBackground(Color.decode("#120228"));

        //Panel de jeu principal
        GamePanel GamePanel = new GamePanel();
        int x = (widthWindow - widthGamePanel) / 2;
        int y = (heightWindow - heightGamePanel) / 2;
        GamePanel.setBounds(x, y, widthGamePanel, heightGamePanel);
        GamePanel.setBackground(Color.decode("#391d6d"));

        layeredPane.add(OverlayPanel, Integer.valueOf(0)); // Arriere plan
        layeredPane.add(GamePanel, Integer.valueOf(1)); // Premier plan

        frame.setContentPane(layeredPane);
        frame.pack();
        frame.setVisible(true);
    }
}

class GamePanel extends JPanel {
    public GamePanel() {

    }
}

class OverlayPanel extends JPanel {

    private Image starImage;
    private Point[] starPositions;
    private final int NUM_STARS = 10;
    private final int STAR_WIDTH = 20;
    private final int STAR_HEIGHT = 20;

    public OverlayPanel() {

        ImageIcon icon = new ImageIcon("src/etoile.png");
        starImage = icon.getImage();

        // Génère des positions aléatoires
        starPositions = new Point[NUM_STARS];
        Random rand = new Random();
        for (int i = 0; i < NUM_STARS; i++) {
            int x = rand.nextInt(1200 - STAR_WIDTH);
            int y = rand.nextInt(600 - STAR_HEIGHT);
            starPositions[i] = new Point(x, y);
        }

        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Peinture de fond propre
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        // Affiche chaque étoile
        for (Point p : starPositions) {
            g.drawImage(starImage, p.x, p.y, STAR_WIDTH, STAR_HEIGHT, this);
        }
    }

}
