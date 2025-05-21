import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image background;

    public ImagePanel(Image background) {
        this.background = background;
        setOpaque(false);
        setLayout(null); // ou GridBagLayout selon besoin
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
