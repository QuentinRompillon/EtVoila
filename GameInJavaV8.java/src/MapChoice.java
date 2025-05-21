import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MapChoice extends JPanel implements KeyListener{

    private int panelWidth = DataBase.panelOneWidth;
    private int panelHeight = DataBase.panelOneHeight;
    private int panelMiddleAxis = DataBase.panelOneMiddleAxis;

    public Text text;
    public Image backgroundImage;
    public Audio audio;
    
    public MapChoice(MainFrame mainFrame) {  
        
        text = new Text();
        backgroundImage = new ImageIcon(getClass().getResource("/img/back1.png")).getImage();

        setLayout(new GridBagLayout()); //to center the panel
        setFocusable(true);
        addKeyListener(this);

        GridBagConstraints gbc = CreateGridBagConstraints.create();
        JPanel contentPanel = CreatePanel.create(panelWidth, panelHeight, Color.black, Color.lightGray, 1, true);
        
        JTextArea textarea = CreateTextArea.create(text.choosethemap.get(MainFrame.language), Color.black, Color.white, 20, panelMiddleAxis, 40, true);
        JButton mapOneButton = CreateButton.create(text.mapOne.get(MainFrame.language),-90 - ((DataBase.mainFrameWidth - panelWidth) / 2),0.3);
        //JButton mapTwoButton = CreateButton.create(text.mapTwo.get(MainFrame.language), 20 -((DataBase.mainFrameWidth - panelWidth) / 2),0.3);
        JButton backtomenuBtn = CreateButton.create(text.backtomenu.get(MainFrame.language),-90 - ((DataBase.mainFrameWidth - panelWidth) / 2), 0.6);
        mapOneButton.addActionListener(_ -> mainFrame.showMapGamePanel());
        backtomenuBtn.addActionListener(_ -> mainFrame.showMenuPanel());

        contentPanel.add(textarea);
        contentPanel.add(mapOneButton);
        //contentPanel.add(mapTwoButton);
        contentPanel.add(backtomenuBtn);

        add(contentPanel, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    @Override public void keyPressed(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
