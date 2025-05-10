import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class ChromeDinosaur extends JPanel implements ActionListener, KeyListener {

    int boardWidth = MainFrame.windowWidth;
    int boardHeight = MainFrame.windowHeight;   

    private MainFrame mainFrame;

    //images
    Image dinosaurImg;
    Image dinosaurDeadImg;
    Image dinosaurJumpImg;
    Image cactus1Img;
    Image cactus2Img;
    Image cactus3Img;

    class Block {
        int x;
        int y;
        int width;
        int height;
        Image img;
    
        Block(int x, int y, int width, int height, Image img) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.img = img;
        }
    }

    //dinosaur
    int dinosaurWidth = 96;
    int dinosaurHeight = 96;
    int dinosaurX = 50;
    int dinosaurY = boardHeight - dinosaurHeight - 36;

    Block dinosaur;

    //cactus
    int cactus1Width = 34;
    int cactus2Width = 69;
    int cactus3Width = 102;

    int cactusHeight = 70;
    int cactusX = 1200;
    int cactusY = boardHeight - cactusHeight - 36;
    ArrayList<Block> cactusArray;

    //physics
    int velocityX = -12;
    int velocityY = 0; //dinosaur jump speed
    int gravity = 1;

    boolean gameOver = false;
    int score = 0;

    Timer gameLoop;
    Timer placeCactusTimer;
    

    public ChromeDinosaur(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setFocusable(true);
        setBackground(Color.lightGray);
        addKeyListener(this);

        dinosaurImg = new ImageIcon(getClass().getResource("/img/perso-run.gif")).getImage();
        dinosaurDeadImg = new ImageIcon(getClass().getResource("/img/perso-dead.png")).getImage();
        dinosaurJumpImg = new ImageIcon(getClass().getResource("/img/perso-jump.png")).getImage();
        cactus1Img = new ImageIcon(getClass().getResource("/img/cactus1.png")).getImage();
        cactus2Img = new ImageIcon(getClass().getResource("/img/cactus2.png")).getImage();
        cactus3Img = new ImageIcon(getClass().getResource("/img/cactus3.png")).getImage();

        //dinosaur
        dinosaur = new Block(dinosaurX, dinosaurY, dinosaurWidth, dinosaurHeight, dinosaurImg);
    
        //cactus
        cactusArray = new ArrayList<Block>();

        //game timer
        gameLoop = new Timer(1000/60, this); //1000/60 = 60 frames per 1000ms (1s), update
        gameLoop.start();
        
        //place cactus timer
        placeCactusTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeCactus();

            }
        });
        placeCactusTimer.start();
    
    }

    void placeCactus() {
        if (gameOver) { 
            return;
        }

        double placeCactusChance = Math.random(); // 0 - 0.9999
        if (placeCactusChance > .90) { //10% you get cactus 3
            Block cactus = new Block(cactusX, cactusY, cactus3Width, cactusHeight, cactus3Img);
            cactusArray.add(cactus);
        }
        else if (placeCactusChance > 0.70) { //20% you get cactus 2
            Block cactus = new Block(cactusX, cactusY, cactus2Width, cactusHeight, cactus2Img);
            cactusArray.add(cactus);
        }
        else if (placeCactusChance > 0.50) { //20% you get cactus1
            Block cactus = new Block(cactusX, cactusY, cactus1Width, cactusHeight, cactus1Img);
            cactusArray.add(cactus);
        }

        if (cactusArray.size() > 10) {
            cactusArray.remove(0);
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        //dinosaur
        g.drawImage(dinosaur.img, dinosaur.x, dinosaur.y, dinosaur.width, dinosaur.height, null);
        
        //cactus
        for (int i = 0; i < cactusArray.size(); i++) {
            Block cactus = cactusArray.get(i);
            g.drawImage(cactus.img, cactus.x, cactus.y, cactus.width, cactus.height, null);
        }

        //score
        g.setColor(Color.black);
        g.setFont(new Font("Courier", Font.PLAIN, 32));
        if (gameOver) { 
            g.drawString("Game Over: " + String.valueOf(score), 10, 35);
        }
        else {
            g.drawString("Score: " + String.valueOf(score), 10, 35);
        }
    }

    public void move() {
        //dinosaur
        velocityY += gravity;
        dinosaur.y += velocityY;

        if (dinosaur.y > dinosaurY) {
            dinosaur.y = dinosaurY;
            velocityY = 0;
            dinosaur.img = dinosaurImg;
        }

        //cactus
        for (int i = 0; i < cactusArray.size(); i++) {
            Block cactus = cactusArray.get(i);
            cactus.x += velocityX;

            if (collision(dinosaur, cactus)) {
                gameOver = true;
                dinosaur.img = dinosaurDeadImg;
            }
        }

        //score
        score++;
    }

    boolean collision(Block a, Block b) {
        return a.x < b.x + b.width && 
               a.x + a.width > b.x &&  
               a.y < b.y + b.height && 
               a.y + a.height > b.y;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (gameOver) { 
            placeCactusTimer.stop();
            gameLoop.stop();
            TopScores.addnewscore(score);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (gameOver) {
                mainFrame.showMenuPanel();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            //System.out.println("JUMP!");
            if (dinosaur.y == dinosaurY) {
                velocityY = -17;
                dinosaur.img = dinosaurJumpImg;
            }

            if (gameOver) { 
                //restart game by resetting conditions
                dinosaur.y = dinosaurY;
                dinosaur.img = dinosaurImg;
                velocityY = 0;

                //cactus
                cactusArray.clear();
                score = 0;
                gameOver = false;
                gameLoop.start();
                placeCactusTimer.start();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
