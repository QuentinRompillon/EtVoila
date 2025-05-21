import javax.swing.*;
import java.awt.*;

public class LoadingScreen extends JPanel {

    private MainFrame mainFrame;
    private ImageIcon loadingGif;

    public LoadingScreen(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setBackground(Color.black);

        // Charger le GIF avec un chemin relatif correct
        loadingGif = new ImageIcon(getClass().getResource("/img/loadingscreen.gif")); // Vérifier si le GIF est bien dans le bon dossier

        // Timer pour afficher le menu après 4 secondes
        Timer timer = new Timer(4500, _ -> showMenuPanel());
        timer.setRepeats(false);
        timer.start();

        // Redessiner le panneau toutes les 50 ms pour animer le GIF
        Timer repaintTimer = new Timer(50, _ -> repaint()); // Appelle repaint() régulièrement
        repaintTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessiner le GIF sur le JPanel et le centrer sans l'étirer
        if (loadingGif != null) {
            // Récupérer la largeur et la hauteur du GIF
            int gifWidth = loadingGif.getIconWidth();
            int gifHeight = loadingGif.getIconHeight();

            double scaleFactor = 0.6;

            int newWidth = (int) (gifWidth * scaleFactor);
            int newHeight = (int) (gifHeight * scaleFactor);

            // Calculer les coordonnées pour centrer l'image
            int x = (getWidth() - newWidth) / 2;
            int y = (getHeight() - newHeight) / 2;



            // Dessiner l'image sans la redimensionner
            g.drawImage(loadingGif.getImage(), x, y, newWidth, newHeight, this);
        }
    }

    private void showMenuPanel() {
        mainFrame.showMenuPanel();  // Cette méthode doit être définie dans ton MainFrame
    }
}
