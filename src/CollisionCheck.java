import java.awt.*;
public class CollisionCheck {
    public static int hits = 0;
    public static int speedAdded = 0;
    public static void player1Collision(Player1 player, Ball ball){
        Rectangle player1Rectangle = new Rectangle(player.getX(),player.getY(),player.getWidth(),player.getLength());
        Rectangle ballRectangle = new Rectangle(ball.getX(),ball.getY(),ball.getWidth(),ball.getLength());
        if (player1Rectangle.intersects(ballRectangle)&&PlayerMovement.player1Down) {
            Ball.ballUpDirection = true;   Ball.angle = 6;  Ball.straight = false;
            hits+=1; Ball.p1Hit= true;
            if (hits%15 == 0&& hits!= 0){
                speedAdded +=1;}
            return;
        }
        if (player1Rectangle.intersects(ballRectangle)&&PlayerMovement.player1Up)   {
            Ball.ballUpDirection = false;  Ball.angle = 6; Ball.straight = false;
            hits+=1; Ball.p1Hit= true;
             if (hits%15 == 0&& hits!= 0){
                speedAdded +=1;}
            return;
        }
        if (player1Rectangle.intersects(ballRectangle)) {
            hits+=1;
            Ball.p1Hit = true;
            Ball.straight = false;
            Ball.angle = 5;
            if (hits%15 == 0&& hits!= 0){
                speedAdded +=1;}
        }

    }
    public static void player2Collision(Player2 player, Ball ball){
        Rectangle player2Rectangle = new Rectangle(player.getX(),player.getY(),player.getWidth(),player.getLength());
        Rectangle ballRectangle = new Rectangle(ball.getX(),ball.getY(),ball.getWidth(),ball.getLength());
        if (player2Rectangle.intersects(ballRectangle)&&PlayerMovement.player2Down){
        Ball.ballUpDirection = true;   Ball.angle = 6;  Ball.straight = false;
        hits+=1; Ball.p1Hit= false;
            if (hits%15 == 0&& hits!= 0){
                speedAdded +=1;}
            return;
        }
        if (player2Rectangle.intersects(ballRectangle)&&PlayerMovement.player2Up){
            Ball.ballUpDirection = false;   Ball.angle = 6;
            Ball.straight = false;
            hits+=1; Ball.p1Hit= false;
            if (hits%15 == 0&& hits!= 0){
                speedAdded +=1;}
            return;
        }
        if (player2Rectangle.intersects(ballRectangle)){
            Ball.p1Hit = false; Ball.straight = false;
            Ball.angle = 5;
            hits+=1;
            if (hits%15 == 0&& hits!= 0){
                speedAdded +=1;}
        }

        }
    }

