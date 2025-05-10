import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class CreateButton {

    public CreateButton() {
    }

    public static JButton create(String text, double middlePosition, double positionFactor){

        JButton button = new JButton(text);
        int xPosition = (int) ((MainFrame.windowWidth / 2) + middlePosition);
        int yPosition = (int) (MainFrame.windowHeight * positionFactor);

        button.setBounds(xPosition, yPosition, 160, 40);
        button.setBackground(Color.decode("#120228"));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        return button;
    }

}
