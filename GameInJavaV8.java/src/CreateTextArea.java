import javax.swing.JTextArea;
import java.awt.*;

public class CreateTextArea {

    public CreateTextArea() {
    }

    public static JTextArea create(String text, Color backgroundColor, Color foregroundColor, int textSize, int xposition, int yposition, boolean center){

        JTextArea textarea = new JTextArea();
        textarea.setText(text);
        textarea.setEditable(false);
        textarea.setBackground(backgroundColor);
        textarea.setForeground(foregroundColor);
        textarea.setFont(new Font("Arial", Font.PLAIN, textSize));

        FontMetrics fm = textarea.getFontMetrics(textarea.getFont());
        int textWidth = fm.stringWidth(textarea.getText());
        int textHeight = fm.getHeight();

        int Xposition;
        if (center) {
            Xposition = xposition - (textWidth / 2);
        }
        else {
            Xposition = xposition;
        }

        textarea.setBounds(Xposition, yposition, textWidth + 10, textHeight + 0);
        return textarea;
    }


}
