import javax.swing.*;
import java.awt.*;

public class LoadingScreen extends JPanel {

    private MainFrame mainFrame;
    private ImageIcon loadingGif;

    public LoadingScreen(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        // Charger le GIF avec un chemin relatif correct
        loadingGif = new ImageIcon(getClass().getResource("/img/loadingscreen.gif")); // Vérifier si le GIF est bien dans le bon dossier

        // Timer pour afficher le menu après 4 secondes
        Timer timer = new Timer(4000, _ -> showMenuPanel());
        timer.setRepeats(false);
        timer.start();

        // Redessiner le panneau toutes les 50 ms pour animer le GIF
        Timer repaintTimer = new Timer(50, _ -> repaint()); // Appelle repaint() régulièrement
        repaintTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessiner le GIF sur le JPanel et étirer l'image pour remplir toute la taille du JPanel
        if (loadingGif != null) {
            // Étirer l'image pour qu'elle prenne toute la place
            g.drawImage(loadingGif.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }

    private void showMenuPanel() {
        mainFrame.showMenuPanel();  // Cette méthode doit être définie dans ton MainFrame
    }
}
