import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class CreateButton {

    public CreateButton() {
    }

    public static JButton create(String text, double middlePosition, double positionFactor){

        JButton button = new JButton(text);
        int xPosition = (int) ((DataBase.panelsWidth / 2) + middlePosition);
        int yPosition = (int) (DataBase.panelsHeight * positionFactor);

        button.setBounds(xPosition, yPosition, 180, 40);
        button.setBackground(Color.decode("#120228"));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        return button;
    }

}
