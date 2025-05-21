public class DataBase {

    //Main Frame
    public static final int mainFrameWidth = 1400; //37
    public static final int mainFrameHeight = 800; //14

    //Current Panel
    public static int currentPanel = 0; // 0 MenuPanel / 1 GameMapPanel

    //Panels
    public static int panelsWidth = mainFrameWidth - 14;
    public static int panelsHeight = mainFrameHeight - 37;
    public static double scaleFactorPanel = 0.75;

        //Panel 1 : ChooseLanguage - TopScores - About
    public static int panelOneWidth = (int) (scaleFactorPanel * panelsWidth);
    public static int panelOneHeight = (int) (scaleFactorPanel * panelsHeight);
    public static int panelOneMiddleAxis = (int) ((panelsWidth / 2) - ((panelsWidth - panelOneWidth) / 2));

        //GameMap
    public static final int gameMapPanelWidth = (int) (scaleFactorPanel * mainFrameWidth);
    public static final int gameMapPanelHeight = (int) (scaleFactorPanel * mainFrameHeight);
    public static final int gameMapPanelLeft = (int) (mainFrameWidth - gameMapPanelWidth - ((mainFrameWidth - gameMapPanelWidth) / 2));
    public static final int gameMapPanelRight = (int) (mainFrameWidth - ((mainFrameWidth - gameMapPanelWidth) / 2));
    public static final int gameMapPanelBottom = (int) (mainFrameHeight - ((mainFrameHeight - gameMapPanelHeight) / 2));
    public static final int gameMapPosX = (int) ((mainFrameWidth - gameMapPanelWidth) / 2);
    public static final int gameMapPosY = (int) ((mainFrameHeight - gameMapPanelHeight) / 2);
    public static final int gameMapBorder = 40;

    //Instructions Panel
    public static final int instructionPanelWidth = (int) (panelsWidth * 0.35);
    public static final int instructionPanelHeight = (int) (panelsHeight * 0.25);
    public static final int instructionPanelX = (int) (panelsWidth / 15);
    public static final int instructionPanelY = (int) (panelsHeight / 5);
    public static final int instructionPanelTextX = (int) (instructionPanelX + (instructionPanelWidth / 15));
    public static final int instructionPanelTextYOne = (int) (instructionPanelY + (instructionPanelHeight * 1/6));
    public static final int instructionPanelTextYTwo = (int) (instructionPanelY + (instructionPanelHeight * 2/6));
    public static final int instructionPanelTextYThree = (int) (instructionPanelY + (instructionPanelHeight * 3/6));
    public static final int instructionPanelTextYFour = (int) (instructionPanelY + (instructionPanelHeight * 4/6));
    public static final int instructionPanelTextYFive = (int) (instructionPanelY + (instructionPanelHeight * 5/6));
    
    //GameOver Panel
    public static final int gameOverPanelWidth = (int) (instructionPanelWidth * 0.5);
    public static final int gameOverPanelHeight = (int) (instructionPanelHeight * 0.5);
    public static final int gameOverPanelX = (int) (panelsWidth * 0.6);
    public static final int gameOverPanelY = (int) (instructionPanelY + ((instructionPanelHeight - gameOverPanelHeight) / 2));
    public static final int gameOverPanelTextX = (int) (gameOverPanelX + (gameOverPanelWidth * 0.5) - 90);
    public static final int gameOverPanelTextY = (int) (gameOverPanelY + (gameOverPanelHeight * 0.5)) + 10;
 
    //Images

    //Characters

    //Obstacles    

}
