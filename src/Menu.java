import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu implements ActionListener {
    public static String[] playerNames = new String[2];
    public static boolean gameOn = false;
    public PlayPanel playPanel = new PlayPanel();
    public PanelSetUp gameStatsPanel = new PanelSetUp(Color.BLACK);
    public PanelSetUp colorPanel = new PanelSetUp(Color.WHITE);
    ImageIcon statsBackGround = new ImageIcon("Images/Stats.png");
    JLabel statsImage = new JLabel();
    JLabel welcome = new JLabel("PONG");
    JLabel maxAllTimeHits = new JLabel();
    JLabel hitsHistory = new JLabel();
    JLabel winHistory = new JLabel();
    JLabel mostHits = new JLabel();
    JLabel win1 = new JLabel();
    JLabel win2 = new JLabel();
    JLabel win3 = new JLabel();
    JLabel win4 = new JLabel();
    JLabel win5 = new JLabel();
    JLabel hits1 = new JLabel();
    JLabel hits2 = new JLabel();
    JLabel hits3 = new JLabel();
    JLabel hits4 = new JLabel();
    JLabel hits5 = new JLabel();
    Color buttonColor = Color.RED;
    JButton names = new JButton();
    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    JButton b5 = new JButton();
    JButton b6 = new JButton();
    JButton b7 = new JButton();
    JButton b8 = new JButton();
    JButton b9 = new JButton();
    JButton b10 = new JButton();
    JButton play = new JButton();
    JButton colors = new JButton();
    JButton stats = new JButton();
    JButton reload = new JButton();
    JButton menuBackGround = new JButton();
    JButton menuButton = new JButton();
    static JButton gameBackGround = new JButton();
    public static JButton resume = new JButton();
    public static JButton playAgain = new JButton();
    public static JButton mainMenu = new JButton();
    public static JButton playerColor = new JButton();
    public static JButton ballColor = new JButton();
    public boolean gBG = false;
    boolean selected = false;
    boolean pC = false;
    boolean bC = false;
    boolean mBG = false;
    boolean mB = false;

    public Menu() {
        reload();
        statsImage.setIcon(statsBackGround);
        statsImage.setBounds(0, 0, 1920, 1080);
        playPanel.addKeyListener(new PlayerMovement());
        main.frame.add(gameStatsPanel);
        gameStatsPanel.setVisible(false);
        main.frame.add(playPanel);
        playPanel.setVisible(false);
        main.frame.add(colorPanel);
        colorPanel.setVisible(false);
        main.frame.add(welcome);
        welcome.setFont(new Font("Verdana", Font.ITALIC, 150));
        welcome.setText("PONG");
        welcome.setForeground(new Color(0xFFFFFF));
        welcome.setBounds((Def.WINDOW_WIDTH / 2) -210, 200, 450 , 200);
        welcome.setVisible(true);
        //Stats Labels
        labelSetUp(maxAllTimeHits, "Most Hits", new Font("Verdana", Font.ITALIC, 60), Color.WHITE, gameStatsPanel, true, 260, 200, 350, 75);
        labelSetUp(hitsHistory, "Hits History", new Font("Verdana", Font.ITALIC, 60), Color.WHITE, gameStatsPanel, true, 780, 200, 350, 75);
        labelSetUp(winHistory,  "Wins History", new Font("Verdana", Font.ITALIC, 60), Color.WHITE, gameStatsPanel, true, 1300, 200, 380, 75);
        labelSetUp(mostHits,  Ball.allTimeMaxHits+"", new Font("Verdana", Font.BOLD, 40), Color.WHITE, gameStatsPanel, true, 350, 300, 350, 75);
        labelSetUp(win1, "None", new Font("Verdana", Font.BOLD, 35), Color.WHITE, gameStatsPanel, true, 1420, 300, 350, 75);
        labelSetUp(win2, "None", new Font("Verdana", Font.BOLD, 35), Color.WHITE, gameStatsPanel, true, 1420, 370, 350, 75);
        labelSetUp(win3, "None", new Font("Verdana", Font.BOLD, 35), Color.WHITE, gameStatsPanel, true, 1420, 440, 350, 75);
        labelSetUp(win4, "None", new Font("Verdana", Font.BOLD, 35), Color.WHITE, gameStatsPanel, true, 1420, 510, 350, 75);
        labelSetUp(win5, "None", new Font("Verdana", Font.BOLD, 35), Color.WHITE, gameStatsPanel, true, 1420, 580, 350, 75);
        labelSetUp(hits1, "0", new Font("Verdana", Font.BOLD, 35), Color.WHITE, gameStatsPanel, true, 925, 300, 350, 75);
        labelSetUp(hits2, "0", new Font("Verdana", Font.BOLD, 35), Color.WHITE, gameStatsPanel, true, 925, 370, 350, 75);
        labelSetUp(hits3, "0", new Font("Verdana", Font.BOLD, 35), Color.WHITE, gameStatsPanel, true, 925, 440, 350, 75);
        labelSetUp(hits4, "0", new Font("Verdana", Font.BOLD, 35), Color.WHITE, gameStatsPanel, true, 925, 510, 350, 75);
        labelSetUp(hits5, "0", new Font("Verdana", Font.BOLD, 35), Color.WHITE, gameStatsPanel, true, 925, 580, 350, 75);
        //Menu Buttons
        buttonSetUp(names, 20, "Names", buttonColor, true, 100, 30, 100, 35);
        buttonSetUp(reload, 18, "Reload", buttonColor, true, 1750 , 30, 100, 35);
        buttonSetUp(stats, 27, "Stats", buttonColor, true, (Def.WINDOW_WIDTH / 2) - 200, 600, 400, 75);
        buttonSetUp(resume, 15,"Resume", buttonColor, false, 885,60 , 150, 30);
        buttonSetUp(play, 27, "Play", buttonColor, true, (Def.WINDOW_WIDTH / 2) - 200, 400, 400, 75);
        buttonSetUp(colors, 27, "Colors", buttonColor, true, (Def.WINDOW_WIDTH / 2) - 200, 500, 400, 75);
        buttonSetUp(mainMenu, 15, "Main Menu", buttonColor, false, 885,20 , 150, 30);
        buttonSetUp(playAgain, 15, "Play Again", buttonColor, false, 885, 60, 150, 30);
        //Color settings buttons
        buttonSetUp(gameBackGround, 27, "Game BackGround", Color.BLACK, false, Def.WINDOW_MIDDLE_X - 150, 200, 300, 50);
        buttonSetUp(playerColor, 27, "Player Color", Color.WHITE, false, Def.WINDOW_MIDDLE_X - 150, 300, 300, 50);
        buttonSetUp(ballColor, 27, "Ball Color", Color.WHITE, false, Def.WINDOW_MIDDLE_X - 150, 400, 300, 50);
        buttonSetUp(menuBackGround, 27, "Menu BackGround", main.frame.getContentPane().getBackground(), false, Def.WINDOW_MIDDLE_X - 150, 500, 300, 50);
        buttonSetUp(menuButton, 27, "Menu Buttons", buttonColor, false, Def.WINDOW_MIDDLE_X - 150, 600, 300, 50);


        main.frame.add(play);
        main.frame.add(names);
        main.frame.add(reload);
        main.frame.add(colors);
        main.frame.add(stats);
        playPanel.add(resume);
        playPanel.add(playAgain);
        mainMenu.addKeyListener(new PlayerMovement());
        resume.addKeyListener(new PlayerMovement());
        colorPanel.add(gameBackGround);
        colorPanel.add(playerColor);
        colorPanel.add(ballColor);
        colorPanel.add(menuBackGround);
        colorPanel.add(menuButton);
        colorPanel.add(b1);
        colorPanel.add(b2);
        colorPanel.add(b3);
        colorPanel.add(b4);
        colorPanel.add(b5);
        colorPanel.add(b6);
        colorPanel.add(b7);
        colorPanel.add(b8);
        colorPanel.add(b9);
        colorPanel.add(b10);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Play")) {
            if (playerNames[0] == null || playerNames[1] == null){playerNameSet("To Play Please Select Player Names"); return;}
            names.setVisible(false);
            reload.setVisible(false);
            welcome.setVisible(false);
            playPanel.add(mainMenu);
            playPanel.setBackground(gameBackGround.getBackground());
            playPanel.setVisible(true);
            mainMenu.setVisible(true);
            resume.setVisible(true);
            play.setVisible(false);
            colors.setVisible(false);
            stats.setVisible(false);
        }
        if (action.equals("Names")){
            playerNameSet("Names for player 1 and player 2");
        }
        if (action.equals("Reload")){
           reload();
           statsReprint();
        }
        if (action.equals("Stats")){
            statsReprint();
            gameStatsPanel.add(reload);
            reload.setVisible(true);
            play.setVisible(false);
            colors.setVisible(false);
            stats.setVisible(false);
            gameStatsPanel.add(mainMenu);
            gameStatsPanel.add(statsImage);
            mostHits.setText(HitDataSave.maxHitsEver+"");
            mainMenu.setVisible(true);
            gameStatsPanel.setVisible(true);
        }
        if (action.equals("Play Again")){
            playPanel.playAgain();
        }
        if (action.equals("Resume")){
            resume.setVisible(false);
            gameOn = true;
            Ball.loser1 = false;
            Ball.loser2 = false;
        }
        if (action.equals("Colors")) {
            welcome.setVisible(false);
            colorPanel.add(mainMenu);
            colors.setVisible(false);
            play.setVisible(false);
            stats.setVisible(false);
            mainMenu.setVisible(true);
            gameOn = false;
            //color buttons
            playerColor.setVisible(true);
            ballColor.setVisible(true);
            menuBackGround.setVisible(true);
            menuButton.setVisible(true);
            gameBackGround.setVisible(true);
            colorPanel.setVisible(true);
        }
        if (action.equals("Main Menu")) {
            main.frame.add(reload);
            names.setVisible(true);
            reload.setVisible(true);
            if (Ball.player1Lives == 0 || Ball.player2Lives == 0){playPanel.playAgain(); }
            welcome.setVisible(true);
            stats.setVisible(true);
            gameOn = false;
            menuButton.setVisible(false);
            PlayerMovement.player2Down = false;
            PlayerMovement.player2Up = false;
            PlayerMovement.player1Up = false;
            PlayerMovement.player1Down = false;
            gameStatsPanel.setVisible(false);
            mainMenu.setVisible(false);
            colorPanel.setVisible(false);
            playPanel.setVisible(false);
            colors.setVisible(true);
            play.setVisible(true);
            gameBackGround.setVisible(false);
            playerColor.setVisible(false);
            ballColor.setVisible(false);
            menuBackGround.setVisible(false);
        }
        if (action.equals("Game BackGround")) {
            if (!selected) {
                selected = true;
                colorSelector(gameBackGround);
            } else {
                moveSelector(gameBackGround);
            }
            gBG = true;
            mBG = false;
            mB = false;
            pC = false;
            bC = false;
        }
        if (action.equals("Player Color")) {
            if (!selected) {
                selected = true;
                colorSelector(playerColor);
            } else {
                moveSelector(playerColor);
            }
            gBG = false;
            mBG = false;
            mB = false;
            pC = true;
            bC = false;
        }
        if (action.equals("Ball Color")) {
            if (!selected) {
                selected = true;
                colorSelector(ballColor);
            } else {
                moveSelector(ballColor);
            }
            gBG = false;
            mBG = false;
            mB = false;
            pC = false;
            bC = true;
        }
        if (action.equals("Menu BackGround")) {
            if (!selected) {
                selected = true;
                colorSelector(menuBackGround);
            } else {
                moveSelector(menuBackGround);
            }
            gBG = false;
            mBG = true;
            mB = false;
            pC = false;
            bC = false;
        }
        if (action.equals("Menu Buttons")) {
            if (!selected) {
                selected = true;
                colorSelector(menuButton);
            } else {
                moveSelector(menuButton);
            }
            gBG = false;
            mBG = false;
            mB = true;
            pC = false;
            bC = false;
        }
        switch (action) {
            case "B" : colorSetter(Color.BLACK); break;
            case "W" : colorSetter(Color.WHITE); break;
            case "R" : colorSetter(Color.RED); break;
            case "O" : colorSetter(Color.ORANGE); break;
            case "Y" : colorSetter(Color.YELLOW);break;
            case "G" : colorSetter(Color.GREEN);break;
            case "BL" : colorSetter(Color.BLUE);break;
            case "P" : colorSetter(Color.PINK);break;
            case "GR" : colorSetter(Color.GRAY);break;
            case "M" : colorSetter(Color.MAGENTA);break;
        }
        }

    private void statsReprint() {
        win1.setText(WinDataSave.winHistory[0]);
        win2.setText(WinDataSave.winHistory[1]);
        win3.setText(WinDataSave.winHistory[2]);
        win4.setText(WinDataSave.winHistory[3]);
        win5.setText(WinDataSave.winHistory[4]);
        hits1.setText(HitDataSave.hitHistory[0]);
        hits2.setText(HitDataSave.hitHistory[1]);
        hits3.setText(HitDataSave.hitHistory[2]);
        hits4.setText(HitDataSave.hitHistory[3]);
        hits5.setText(HitDataSave.hitHistory[4]);
        mostHits.setText(Integer.toString(HitDataSave.maxHitsEver));
    }

    private void playerNameSet(String errorMessage) {
        int counter = 0;
        try {
            while (counter<2){
                playerNames[counter] = JOptionPane.showInputDialog(errorMessage);
                if (playerNames[counter].length() > 6){
                    JOptionPane.showMessageDialog(null, "You must use up to 6 characters!"); counter--;
                }
                counter++;
            }
        }catch (NullPointerException e){
            System.out.println("Error Entering Names");
        }
    }
    public void reload(){
        new WinDataSave();
        new HitDataSave();
    }

    public void labelSetUp(JLabel label, String text, Font font, Color color, JPanel panel, boolean visible, int x, int y, int z, int w){
            label.setText(text);
            label.setFont(font);
            label.setForeground(color);
            label.setBounds(x, y, z, w);
            panel.add(label);
            label.setVisible(visible);

        }
        public void buttonSetUp(JButton button,int fontSize, String text, Color color, Boolean visible, int x, int y, int z, int w) {
            button.setBounds(x, y, z, w);
            button.setFont(new Font("Dialog", Font.BOLD, fontSize));
            button.setBackground(color);
            button.setText(text);
            button.setVisible(visible);
            button.addActionListener(this);
    }
    public void colorSelector(JButton button) {
        int x = button.getX() + button.getWidth() + 20;
        int y1 = button.getY()+420;
        int y2 = button.getY()+480;
        int y3 = button.getY()+540;
        buttonSetUp(b1, 27, "B", Color.BLACK, true, button.getX() + button.getWidth() + 20, button.getY(), 50, 50);
        buttonSetUp(b2, 27, "W", Color.WHITE, true, button.getX() + button.getWidth() + 20, button.getY() + 60, 50, 50);
        buttonSetUp(b3, 27, "R", Color.RED, true, button.getX() + button.getWidth() + 20, button.getY() + 120, 50, 50);
        buttonSetUp(b4, 27, "O", Color.ORANGE, true, button.getX() + button.getWidth() + 20, button.getY() + 180, 50, 50);
        buttonSetUp(b5, 27, "Y", Color.YELLOW, true, button.getX() + button.getWidth() + 20, button.getY() + 240, 50, 50);
        buttonSetUp(b6, 27, "G", Color.GREEN, true, button.getX() + button.getWidth() + 20, button.getY() + 300, 50, 50);
        buttonSetUp(b7, 27, "BL", Color.BLUE, true, button.getX() + button.getWidth() + 20, button.getY() + 360, 50, 50);
        if(button.getText().equals("Menu BackGround")||button.getText().equals("Menu Buttons")){
            x += 60;
            y1 = button.getY();
            y2 = button.getY()+60;
            y3 = button.getY()+120;
        }
        buttonSetUp(b8, 27, "P", Color.PINK, true, x, y1, 50, 50);
        buttonSetUp(b9, 27, "GR", Color.GRAY, true, x, y2, 50, 50);
        buttonSetUp(b10, 27,"M", Color.MAGENTA, true, x, y3, 50, 50);
    }
    public void moveSelector(JButton button) {
        int x = button.getX() + button.getWidth() + 20;
        int y1 = button.getY()+420;
        int y2 = button.getY()+480;
        int y3 = button.getY()+540;
        b1.setBounds(button.getX() + button.getWidth() + 20, button.getY(), 50, 50);
        b2.setBounds(button.getX() + button.getWidth() + 20, button.getY() + 60, 50, 50);
        b3.setBounds(button.getX() + button.getWidth() + 20, button.getY() + 120, 50, 50);
        b4.setBounds(button.getX() + button.getWidth() + 20, button.getY() + 180, 50, 50);
        b5.setBounds(button.getX() + button.getWidth() + 20, button.getY() + 240, 50, 50);
        b6.setBounds(button.getX() + button.getWidth() + 20, button.getY() + 300, 50, 50);
        b7.setBounds(button.getX() + button.getWidth() + 20, button.getY() + 360, 50, 50);
        if(button.getText().equals("Menu BackGround")||button.getText().equals("Menu Buttons")){
             x += 60;
             y1 = button.getY();
             y2 = button.getY()+60;
             y3 = button.getY()+120;
        }
        b8.setBounds (x, y1, 50, 50);
        b9.setBounds (x, y2, 50, 50);
        b10.setBounds(x, y3, 50, 50);

    }
    public void colorSetter(Color color){
       if (mB){
           menuButton.setBackground(color);
           play.setBackground(color);
           colors.setBackground(color);
           mainMenu.setBackground(color);
           resume.setBackground(color);
           stats.setBackground(color);
           reload.setBackground(color);
           names.setBackground(color);

       }
       if (gBG){
           gameBackGround.setBackground(color);
       }
       if (pC){
           playerColor.setBackground(color);
       }

       if (mBG){
           main.frame.getContentPane().setBackground(color);
           menuBackGround.setBackground(color);
       }
       if (bC){
           ballColor.setBackground(color);
       }
    }
}

