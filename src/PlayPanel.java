import javax.swing.*;
import java.awt.*;

public class PlayPanel extends JPanel {
    private final Ball ball;
    public static Player1 player1;
    public static Player2 player2;
    Graphics g;

    public PlayPanel(){
        ball = new Ball(960, 520, 15, 15);
        player1 = new Player1(35, (Def.WINDOW_HEIGHT/2)-(150/2) ,15 , 150);
        player2 = new Player2(Def.WINDOW_WIDTH-50, (Def.WINDOW_HEIGHT/2)-(150/2), 15, 150);

        this.setBackground(Color.BLACK);
        this.setBounds(0, 0, 1920,1080);
        this.setLayout(null);
        this.setVisible(true);
        this.mainGameLoop();


    }
    public void paint(Graphics g){
        this.g = g;
        super.paint(g);
        ball.paint(g);
        player1.paint(g);
        player2.paint(g);
        if (!Menu.resume.isVisible() && !Menu.playAgain.isVisible()){
            ball.paintHits(this.g);
        }
        if (Ball.loser1){
            ball.paintLose1(this.g);
        }
        if (Ball.loser2){
            ball.paintLose2(this.g);
        }
    }
    public void playAgain(){
        new WinDataSave();
        Ball.loser1 = false;
        Ball.loser2 = false;
        Ball.player1Lives = 3;
        Ball.player2Lives = 3;
        player1.resume();
        player2.resume();
        ball.playerLoseSet();
    }

    private void mainGameLoop() {
        new Thread(() -> {
            while (true) {

                CollisionCheck.player1Collision(player1,ball);
                CollisionCheck.player2Collision(player2,ball);

                ball.ballMove();
                if (PlayerMovement.player1Up){ player1.p1Up();}
                if (PlayerMovement.player1Down){ player1.p1Down();}
                if (PlayerMovement.player2Up){ player2.p1Up();}
                if (PlayerMovement.player2Down){ player2.p1Down();}
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    }
