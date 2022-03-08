import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class main extends JFrame {
    public static JFrame frame = new JFrame();
    public static void main(String[] args) {
        new main();
    }
    public main() {
        frame.setLayout(null);
        frame.setSize(1920,1080);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Pong");
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.BLACK);
        Menu menu = new Menu();
        frame.setVisible(true);
        this.addKeyListener(new PlayerMovement());

    }
}
