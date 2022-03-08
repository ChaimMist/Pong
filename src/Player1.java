import javax.swing.*;
import java.awt.*;

public class Player1 {
    Rectangle player1Rectangle;
    Rectangle player2Rectangle;

    private int x;
    private int y;
    private int width;
    private int length;
    public Player1(int x, int y, int width, int length){


        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
    }
    public int getX(){ return x;}
    public int getY(){ return y;}
    public int getWidth(){ return width;}
    public int getLength(){ return length;}



    public void paint(Graphics g){
        g.setColor(Menu.playerColor.getBackground());
        g.fillRect(x,y,width,length);
    }

    public void p1Up(){
        if(y>0&&Menu.gameOn){
            this.y-=7;
        }
    }

    public void p1Down(){
        if(y<1080-45-this.length&&Menu.gameOn){
            this.y+=7;}

    }


    public void resume() {
        this.y = (Def.WINDOW_HEIGHT/2)-(150/2);

    }
}
