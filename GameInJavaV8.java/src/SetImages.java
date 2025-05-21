import java.awt.*;
import javax.swing.*;

public class SetImages {

    //panel backgrounds
    static Image menuPanel;
    static Image gameMapPanel;

    static Image panelsImage;

    //characters
    static Image characterImg; 
    static Image characterDeadImg;
    static Image characterJumpImg;
    static Image characterDownImg;

    //ground obstacle
    static Image cactus1Img;
    static Image cactus2Img;
    static Image cactus3Img;
    static Image tourEiffelImg;
    static Image panneauImg;
    static Image arcdetriompheImg;
    static Image montmartreImg;

    //sky obstacle
    static Image birdImg;
    static Image flechesImg;

    //end gates
    static Image leftGate;
    static Image rightGate;

    //endText
    static Image endText;
    static Image gameOverText;

    //reset button
    static ImageIcon resetButton;
    

    public SetImages() {

        characterImg = new ImageIcon(getClass().getResource("/img/perso-run.gif")).getImage();
        characterDeadImg = new ImageIcon(getClass().getResource("/img/perso-dead.png")).getImage();
        characterJumpImg = new ImageIcon(getClass().getResource("/img/perso-jump.png")).getImage();
        characterDownImg = new ImageIcon(getClass().getResource("/img/perso-duck.gif")).getImage();
        cactus1Img = new ImageIcon(getClass().getResource("/img/cactus1.png")).getImage();
        cactus2Img = new ImageIcon(getClass().getResource("/img/cactus2.png")).getImage();
        cactus3Img = new ImageIcon(getClass().getResource("/img/cactus3.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("/img/bird20.gif")).getImage();
        flechesImg = new ImageIcon(getClass().getResource("/img/fleches.png")).getImage();
        panneauImg = new ImageIcon(getClass().getResource("/img/panneau.png")).getImage();
        arcdetriompheImg = new ImageIcon(getClass().getResource("/img/arcdetriomphe.png")).getImage();
        tourEiffelImg = new ImageIcon(getClass().getResource("/img/tourEiffelv3.png")).getImage();
        montmartreImg = new ImageIcon(getClass().getResource("/img/montmartre.png")).getImage();

        menuPanel = new ImageIcon(getClass().getResource("/img/back1.png")).getImage();
        gameMapPanel = new ImageIcon(getClass().getResource("/img/backgame1.jpg")).getImage();
        //panelsImage = new ImageIcon(getClass().getResource("/img/ciel.png")).getImage();
        
        leftGate = new ImageIcon(getClass().getResource("/img/portegauche4.png")).getImage();
        rightGate = new ImageIcon(getClass().getResource("/img/portedroite4.png")).getImage();
        endText = new ImageIcon(getClass().getResource("/img/endText.png")).getImage();
        resetButton = new ImageIcon(getClass().getResource("/img/reset.png"));
    }

}
