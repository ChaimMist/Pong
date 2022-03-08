import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerMovement implements KeyListener {
    public static boolean player1Up;
    public static boolean player2Up;
    public static boolean player1Down;
    public static boolean player2Down;

    public PlayerMovement(){
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_UP:
                player2Up = true;
                break;
            case KeyEvent.VK_DOWN:
                player2Down = true;
                break;
            case KeyEvent.VK_W:
                player1Up = true;
                break;
            case KeyEvent.VK_S:
                player1Down = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_UP:
                player2Up = false;
                break;
            case KeyEvent.VK_DOWN:
                player2Down = false;
                break;
            case KeyEvent.VK_W:
                player1Up = false;
                break;
            case KeyEvent.VK_S:
                player1Down = false;
        }
    }
}
