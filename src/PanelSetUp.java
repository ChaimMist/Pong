import javax.swing.*;
import java.awt.*;

public class PanelSetUp extends JPanel{
    //If you need to make more Panels.. this is a builder.
    public PanelSetUp(Color backGround){
        this.setBounds(0, 0, Def.WINDOW_WIDTH, Def.WINDOW_HEIGHT);
        this.setLayout(null);
        this.setBackground(backGround);
    }
}
