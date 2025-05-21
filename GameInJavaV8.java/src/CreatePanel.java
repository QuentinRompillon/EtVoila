import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.*;

public class CreatePanel {

    public CreatePanel() {
    }

    public static JPanel create(int widhtPanel, int heightPanel,Color backgroundColor, Color borderColor, int borderthickness, boolean rounded) {

        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(widhtPanel, heightPanel));
        panel.setBackground(backgroundColor);
        panel.setBorder(BorderFactory.createLineBorder(borderColor, borderthickness, rounded));

        return panel;
    }

}
