public class SetObject {

    static double scaleZoom = 1.5;

    //character
    public static int characterWidth = (int) (96 * scaleZoom);
    public static int characterHeight = (int) (96 * scaleZoom);
    public static int characterHeightDown = (int) (65 * scaleZoom);
    public static int characterX = 50;
    public static int characterY = DataBase.panelsHeight - characterHeight;
    public static int characterDownY = DataBase.panelsHeight - characterHeightDown;


    //obstacle
    //on the ground :
    //panneau 
    public static int panneauWidth = (int) (34 * (scaleZoom + 0.8));
    public static int panneauHeight = (int) (70 * (scaleZoom + 0.8));
    public static int panneauX = DataBase.panelsWidth;
    public static int panneauY  = DataBase.panelsHeight - panneauHeight;

    //arc de triomphe
    public static int arcdetriompheWidth = (int) (100 * scaleZoom);
    public static int arcdetriompheHeight = (int) (100 * scaleZoom);
    public static int arcdetriompheX = DataBase.panelsWidth;
    public static int arcdetriompheY = DataBase.panelsHeight - arcdetriompheHeight;

    //tour eiffel
    public static int tourEiffelWidth = (int) (54 * (scaleZoom + 0.5));
    public static int tourEiffelHeight = (int) (100 * (scaleZoom + 0.5));
    public static int tourEiffelX = DataBase.panelsWidth;
    public static int tourEiffelY = DataBase.panelsHeight - tourEiffelHeight;

    //montmartre
    public static int montmartreWidth = (int) (100 * scaleZoom);
    public static int montmartreHeight = (int) (100 * scaleZoom);
    public static int montmartreX = DataBase.panelsWidth;
    public static int montmartreY = DataBase.panelsHeight - montmartreHeight;

    //in the sky

    //fleches
    public static int flechesWidth = (int) (97 * scaleZoom);
    public static int flechesHeight = (int) (50 * scaleZoom); //68
    public static int flechesX = DataBase.panelsWidth;
    public static int flechesY = DataBase.panelsHeight - flechesHeight - characterHeightDown - 40;

    //birds
    public static int birdWidth = (int) (90 * scaleZoom);
    public static int birdHeight = (int) (64 * scaleZoom);
    public static int birdX = DataBase.panelsWidth;
    public static int birdY = DataBase.panelsHeight - birdHeight - characterHeight - 40;

    //gates
    //left gate
    public static int leftGateWidth = (int) (36 * (scaleZoom + 0.5));
    public static int leftGateHeight = (int) (100 * (scaleZoom + 0.5));
    public static int leftGateX = DataBase.panelsWidth - leftGateWidth;
    public static int leftGateY = DataBase.panelsHeight - leftGateHeight;

    //right gate
    public static int rightGateWidth = (int) (52 * (scaleZoom + 0.5));
    public static int rightGateHeight = (int) (100 * (scaleZoom + 0.5));
    public static int rightGateX = DataBase.panelsWidth - rightGateWidth;
    public static int rightGateY = DataBase.panelsHeight - rightGateHeight;

    //reset button
    public static int resetButtonWidth = 76;
    public static int resetButtonHeight = 68;
    

    public SetObject() {
    }
}
