import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class GameMap extends JPanel implements ActionListener, KeyListener {

    private MainFrame mainFrame;
    private Image backgroundImage;
    private Text text;
    public Audio audioplayer;

    class Block {
        int x, y, width, height;
        Image img;

        Block(int x, int y, int width, int height, Image img) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.img = img;
            }
    }
    
    //physics
    int velocityX = -12;
    int velocityY = 0; //character jump speed
    int gravity = 1;
    int velocityCharacterX = 5;

    int progress = 0;
    int timePlaceObstacle = 1000;
    int accelerationTime = 10000;
    Block character;
    ArrayList<Block> obstacleArray;
    Timer gameLoop;
    Timer accelerationtimer;
    Timer placeObstacleTimer;
    Timer scoreTimer;
    boolean characterDown = false;
    boolean gameOver = false;
    boolean endGame = false;
    boolean startingGame = true;
    boolean endOfEndGameAnimation = false;
    boolean scoreAdded = false;
    boolean musicPlayed = false;
    JButton resetButton;
    JButton backtomenuBtn;    

    public GameMap(MainFrame mainFrame) {

        this.mainFrame = mainFrame;
        this.setLayout(null);
        text = new Text();
        new SetImages();

        setPreferredSize(new Dimension(getWidth(), getHeight()));
        setFocusable(true);
        addKeyListener(this);

        backgroundImage = SetImages.gameMapPanel;
        audioplayer = new Audio();

        resetButton = new JButton(SetImages.resetButton);
        resetButton.setBounds((DataBase.panelsWidth / 2) - (SetObject.resetButtonWidth / 3), (DataBase.panelsHeight / 4) + 20, SetObject.resetButtonWidth - 15, SetObject.resetButtonHeight - 15);
        resetButton.setBorder(BorderFactory.createLineBorder(Color.gray, 2, true));
        resetButton.addActionListener(_ -> {
            velocityX = -12;
            velocityY = 0;
            progress = 0;
            character.y = SetObject.characterY;
            character.img = SetImages.characterImg;
            timePlaceObstacle = 1000;
            obstacleArray.clear();
            gameOver = false;
            endGame = false;
            endOfEndGameAnimation = false;
            scoreAdded = false;
            this.remove(resetButton);
            this.remove(backtomenuBtn);
            gameLoop.start();
            placeObstacleTimer.start();
            accelerationtimer.start();
            scoreTimer.start();
            audioplayer.PlayMusic(1);
            GameMap.this.requestFocusInWindow();
        });

        backtomenuBtn = CreateButton.create(text.backtomenu.get(MainFrame.language),-90, 0.9);
        backtomenuBtn.addActionListener(_ -> { mainFrame.showMenuPanel(); });

        character = new Block(SetObject.characterX, SetObject.characterY, SetObject.characterWidth, SetObject.characterHeight, SetImages.characterImg);
        obstacleArray = new ArrayList<Block>();

        gameLoop = new Timer(1000/60, this);
        placeObstacleTimer = new Timer(timePlaceObstacle, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeObstacle();
            }
        });

        accelerationtimer = new Timer(accelerationTime, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                velocityX -= 1;
                timePlaceObstacle -= 50;
            }
        });

        scoreTimer = new Timer(940, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progress += 1;
            }
        });

    }









    /***** Fonctions *****/

    public void placeObstacle() {

        double placeObstacleChance = Math.random(); // 0 - 0.9999
        if (placeObstacleChance > 0.90) { //10% you get big one
            Block obstacle = new Block(SetObject.tourEiffelX, SetObject.tourEiffelY, SetObject.tourEiffelWidth, SetObject.tourEiffelHeight, SetImages.tourEiffelImg);
            obstacleArray.add(obstacle);
        }
        else if (placeObstacleChance > 0.75) { //10% you get small two
            Block obstacle = new Block(SetObject.arcdetriompheX, SetObject.arcdetriompheY, SetObject.arcdetriompheWidth, SetObject.arcdetriompheHeight, SetImages.arcdetriompheImg);
            obstacleArray.add(obstacle);
        }
        else if (placeObstacleChance > 0.50) { //10% you get small one
            Block obstacle = new Block(SetObject.panneauX, SetObject.panneauY, SetObject.panneauWidth, SetObject.panneauHeight, SetImages.panneauImg);
            obstacleArray.add(obstacle);
        }
        else if (placeObstacleChance > 0.40) { //10% you get sky one
            Block obstacle = new Block(SetObject.birdX, SetObject.birdY, SetObject.birdWidth, SetObject.birdHeight, SetImages.birdImg);
            obstacleArray.add(obstacle);
        }
        else if (placeObstacleChance > 0.30) { //10% you get sky two
             Block obstacle = new Block(SetObject.flechesX, SetObject.flechesY, SetObject.flechesWidth, SetObject.flechesHeight, SetImages.flechesImg);
            obstacleArray.add(obstacle);
        }
        if (obstacleArray.size() > 10) {
            obstacleArray.remove(0);
        }
    }


    boolean collision(Block a, Block b) {
        return a.x < b.x + b.width && 
               a.x + a.width > b.x &&  
               a.y < b.y + b.height && 
               a.y + a.height > b.y;
    }






    /***** Move *****/

    public void move() {

        velocityY += gravity;
        character.y += velocityY;

        if ((character.y > SetObject.characterY) || (character.y > SetObject.characterDownY)) {
            if (characterDown) {
                character.y = SetObject.characterDownY;
                character.height = SetObject.characterHeightDown;
                character.img = SetImages.characterDownImg;
            }
            else {
                character.y = SetObject.characterY;
                character.height = SetObject.characterHeight;
                character.img = SetImages.characterImg;
            }
            velocityY = 0;
        }

        //obstacle
        for (int i = 0; i < obstacleArray.size(); i++) {
            Block obstacle = obstacleArray.get(i);
            obstacle.x += velocityX;

            if (collision(character, obstacle)) {
                gameOver = true;
                character.img = SetImages.characterDeadImg;
            }
        }

        if (progress == 100 && !endOfEndGameAnimation) {
            character.height = SetObject.characterHeight;
            character.y = SetObject.characterY;
            character.img = SetImages.characterImg;
            endGame = true;
            character.x += velocityCharacterX;
        }

        if (character.x == DataBase.panelsWidth + 4) {
            endOfEndGameAnimation = true;
            
        }
    }







    /***** Draw *****/

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {  

        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        if (endGame) {
            g.drawImage(SetImages.leftGate, SetObject.leftGateX - SetObject.rightGateWidth, SetObject.leftGateY, SetObject.leftGateWidth, SetObject.leftGateHeight, null);
        }

        if (startingGame) {
            Graphics2D g2d = (Graphics2D) g;
            Color opaque = Color.decode("#2f3fd8");
            Color transparent = new Color(opaque.getRed(), opaque.getGreen(), opaque.getBlue(), 192); // alpha = 128
            g2d.setColor(transparent);
            g2d.fillRect(DataBase.instructionPanelX, DataBase.instructionPanelY, DataBase.instructionPanelWidth, DataBase.instructionPanelHeight);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(DataBase.instructionPanelX, DataBase.instructionPanelY, DataBase.instructionPanelWidth, DataBase.instructionPanelHeight);
            g2d.setColor(Color.BLACK); // couleur du texte
            g2d.setFont(new Font("Arial", Font.BOLD, 18)); // optionnel : définir la police
            g2d.drawString(text.instruction1.get(MainFrame.language), DataBase.instructionPanelTextX, DataBase.instructionPanelTextYOne + 5);
            g2d.drawString(text.instruction2.get(MainFrame.language), DataBase.instructionPanelTextX, DataBase.instructionPanelTextYTwo + 5);
            g2d.drawString(text.instruction3.get(MainFrame.language), DataBase.instructionPanelTextX, DataBase.instructionPanelTextYThree + 5);
            g2d.drawString(text.instruction4.get(MainFrame.language), DataBase.instructionPanelTextX, DataBase.instructionPanelTextYFour + 5);
            g2d.drawString(text.instruction5.get(MainFrame.language), DataBase.instructionPanelTextX, DataBase.instructionPanelTextYFive + 5);
        }

        Graphics2D g2d2 = (Graphics2D) g;
        Color opaque = Color.black;
        Color transparent = new Color(opaque.getRed(), opaque.getGreen(), opaque.getBlue(), 160); // alpha = 128
        g2d2.setColor(transparent);
        g2d2.fillRect(0,0,DataBase.panelsWidth, DataBase.gameMapBorder);
        g2d2.drawRect(0,0,DataBase.panelsWidth, DataBase.gameMapBorder);
        g2d2.setColor(Color.white);
        Font font = new Font("Arial", Font.BOLD, 18);
        g2d2.setFont(font);
        FontMetrics metrics = g2d2.getFontMetrics(font);
        String str = text.mapOneName.get(MainFrame.language);
        int textHeight = metrics.getHeight();
        int textYPosition = (DataBase.gameMapBorder - textHeight) / 2 + metrics.getAscent();
        int textWidth = metrics.stringWidth(str);
        g2d2.drawString(str,(DataBase.panelsWidth /2) - (textWidth/2) , textYPosition);
        g2d2.drawString(text.mapOne.get(MainFrame.language), 20, textYPosition);
        str = text.timeToComplete.get(MainFrame.language);
        textWidth = metrics.stringWidth(str);
        g2d2.drawString(text.timeToComplete.get(MainFrame.language) + "1'34''", DataBase.panelsWidth - textWidth - 60, textYPosition);


        if (gameOver) { 
            g.setColor(Color.white);
            String texte = "Game Over";
            Font police = new Font("Arial", Font.BOLD, 50);
            g.setFont(police);
            FontMetrics metrics2 = g.getFontMetrics(police);
            int width = metrics2.stringWidth(texte);
            //int height = metrics.getHeight();
            g.drawString(texte, DataBase.panelsWidth / 2 - width / 2, DataBase.panelsHeight / 4);
            this.add(resetButton);
            this.add(backtomenuBtn);
        }

        g.drawImage(character.img, character.x, character.y, character.width, character.height, null);

        for (int i = 0; i < obstacleArray.size(); i++) {
            Block obstacle = obstacleArray.get(i);
            g.drawImage(obstacle.img, obstacle.x, obstacle.y, obstacle.width, obstacle.height, null);
        }

        if (!startingGame) {
            g.setColor(Color.white);
            String textprogress = text.progress.get(MainFrame.language) + String.valueOf(progress) + "%";
            Font policeprogress = new Font("Arial", Font.BOLD, 22);
            g.setFont(policeprogress);
            FontMetrics metricsprogress = g.getFontMetrics(policeprogress);
            int widhtprogress = metricsprogress.stringWidth(textprogress);
            g.drawString(textprogress, (DataBase.panelsWidth / 2) - widhtprogress / 2, 80);
        }

        if (endGame) {
            g.drawImage(SetImages.endText, (DataBase.panelsWidth / 2) - 250 , (DataBase.panelsHeight / 4) - 61, null);
            g.drawImage(SetImages.rightGate, SetObject.rightGateX, SetObject.rightGateY, SetObject.rightGateWidth, SetObject.rightGateHeight, null);
        }

        if (endOfEndGameAnimation) {
            this.add(backtomenuBtn);
        }
    }









    /***** Actions *****/
    
    @Override public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if ((character.y == SetObject.characterY) && !gameOver && !startingGame && !endGame) {
                velocityY = -25;
                character.img = SetImages.characterJumpImg;
            }
            if (gameOver || startingGame) { 
                velocityX = -12;
                character.y = SetObject.characterY;
                character.img = SetImages.characterImg;
                velocityY = 0;
                progress = 0;
                timePlaceObstacle = 1000;
                obstacleArray.clear();
                gameOver = false;
                endGame = false;
                endOfEndGameAnimation = false;
                scoreAdded = false;
                this.remove(resetButton);
                this.remove(backtomenuBtn);
                gameLoop.start();
                placeObstacleTimer.start();
                accelerationtimer.start();
                scoreTimer.start();
                audioplayer.PlayMusic(1);
            }

            if (startingGame) {
                startingGame = false;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if ((character.y == SetObject.characterY) && !gameOver && !startingGame && !endGame) {
                velocityY = -25;
                character.img = SetImages.characterJumpImg;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if ((character.y == SetObject.characterY) && !gameOver && !startingGame && !endGame) {
                characterDown = true;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_T) {
            if (gameOver || startingGame || endOfEndGameAnimation) {
                mainFrame.showTopscoresPanel();
            }
        }   
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (gameOver || startingGame || endOfEndGameAnimation) {
                mainFrame.showMenuPanel();
            }
        }
    }

    @Override public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (!endGame) {
                    characterDown = false;
                }
                
            }
    }
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (gameOver || endGame) { 
            placeObstacleTimer.stop();
            accelerationtimer.stop();
            scoreTimer.stop();
            if (!scoreAdded) {
                TopScores.addnewscore(progress);
                scoreAdded = true;
            }
            audioplayer.StopMusic();

        }
        if (gameOver || endOfEndGameAnimation) {
            gameLoop.stop() ;
        }

        if (progress == 98) {
            placeObstacleTimer.stop();
        }
    }
}
