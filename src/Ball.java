import java.awt.*;

public class Ball  {

    Color DARK_RED = new Color(0x9D0202);
     private int gamesPlayed = 0;
     static int allTimeMaxHits = 0;
     static boolean ballUpDirection = false;
     static boolean p1Hit = false;
     static boolean straight = true;
     static boolean loser1 = false;
     static boolean loser2 = false;
     static int player1Lives = 3;
     static int player2Lives = 3;
     static int angle = 4;
     int x, y, width, length;
     Font loseFont;

    public Ball(int x, int y, int width, int length){
           this.x = x;
           this.y = y;
           this.width = width;
           this.length = length;
    }
    public int getX(){ return x;    }
    public int getY(){ return y;    }
    public int getWidth() { return width;   }
    public int getLength(){ return length;  }

public void paint(Graphics g) {
        g.setColor(Menu.ballColor.getBackground());
        g.fillOval(x, y, width, length);
        paintScores(g);
        speedAmplifierText(g);

if (player1Lives == 0 || player2Lives == 0){
    Menu.gameOn = false;
    Menu.playAgain.setVisible(true);
}
        if (y>=1020){ ballUpDirection = true;   }
        if (y<=0)   { ballUpDirection = false;  }
        if (x>=1920){
            maxHitsCheck(CollisionCheck.hits);
            CollisionCheck.hits = 0;
            CollisionCheck.speedAdded = 0;
            player2Lives-=1;
            playerLoseSet();
        if (player2Lives == 0){
            WinDataSave.temp.add(Menu.playerNames[0]);
            winHistorySet(Menu.playerNames[0], gamesPlayed);    playAgain();  loser2 = true;
            gamesPlayed+=1;     }
}


        if (x<=0 ){
            maxHitsCheck(CollisionCheck.hits);
            CollisionCheck.hits = 0;
            CollisionCheck.speedAdded = 0;
            player1Lives -=1;
            playerLoseSet();
                if (player1Lives == 0){
                    WinDataSave.temp.add(Menu.playerNames[1]);
                    winHistorySet(Menu.playerNames[1], gamesPlayed);
                    playAgain();  loser1 = true;
                    gamesPlayed+=1;
                }
}


}

    private void maxHitsCheck(int hits) {
        if (allTimeMaxHits<hits){
            allTimeMaxHits = hits;
            String x = Integer.toString(hits);
            HitDataSave.hitTemp.add(x);
        }
        }
    private void winHistorySet(String winner, int gamesPlayed){
        if (gamesPlayed >= 5){
            winHistoryMove();
            WinDataSave.winHistory[0] = winner;
        }
        else {
        WinDataSave.winHistory[gamesPlayed] = winner;
        }
    }


    private void winHistoryMove() {
        for (int i = 0; i < WinDataSave.winHistory.length; i++) {
            if (i == WinDataSave.winHistory.length - 1){
                WinDataSave.winHistory[0] = WinDataSave.winHistory[4];
            }
            else{
             WinDataSave.winHistory[i] = WinDataSave.winHistory[i+1];
            }
        }
    }


    public void paintHits(Graphics g){
        g.setFont(new Font("Verdana", Font.ITALIC, 26));
        g.setColor(DARK_RED);
        g.drawString("Hits: "+CollisionCheck.hits, 910, 80);

    }
    private void speedAmplifierText(Graphics g) {
        g.setFont(new Font("Verdana", Font.ITALIC, 25));
        g.setColor(DARK_RED);
        g.drawString("Speed Amplifier: "+CollisionCheck.speedAdded, 830, 1000);
    }
    private void paintScores(Graphics g) {
        g.setFont(new Font("Verdana", Font.ITALIC, 26));
        g.setColor(DARK_RED);
        g.drawString(Menu.playerNames[0]+ "\n Lives: "+ player1Lives, 35, 35);
        g.drawString(Menu.playerNames[1]+ "\n Lives: "+player2Lives, 1675, 35);
    }



    public void playerLoseSet() {
        straight = true;
        Menu.gameOn = false;
        Menu.playAgain.setVisible(false);
        Menu.resume.setVisible(true);
            y = 520;
            x = 960;
    }
        public void playAgain (){
            Menu.resume.setVisible(false);
            Menu.playAgain.setVisible(true);

        }
    public void ballMove(){
        if (Menu.gameOn){
            if (straight){
                this.x = this.x - 13 - CollisionCheck.speedAdded;
                return;
            }
            if (!ballUpDirection && !p1Hit){
                this.x = this.x - 13- CollisionCheck.speedAdded;
                this.y+=angle;
                }
            if (ballUpDirection && !p1Hit){
                this.x = this.x - 13 - CollisionCheck.speedAdded;
                this.y-=angle;
            }
            if (!ballUpDirection && p1Hit){
                this.x = this.x + 13 + CollisionCheck.speedAdded;
                this.y+=angle;
            }
            if (ballUpDirection && p1Hit){
                this.x = this.x + 13 + CollisionCheck.speedAdded;
                this.y-=angle;
            }
        }
    }
    public void paintLose1 (Graphics g){
        loseFont = g.getFont().deriveFont(185.0f);
        g.setFont( loseFont);
        g.setColor(DARK_RED);
        g.drawString(Menu.playerNames[0]+ " Is Trash", 230 , 300);

    }
    public void paintLose2 (Graphics g){
        loseFont = g.getFont().deriveFont(185.0f);
        g.setFont( loseFont);
        g.setColor(DARK_RED);
        g.drawString(Menu.playerNames[1]+ " Is Trash", 230 , 300);

    }
}
