package main;

import javax.swing.*;

public class Main {

//    static ImageIcon logo = new ImageIcon(Main.class.getClassLoader().
//            getResource("res/chess.png"));

    public static void main(String[] args) {

        JFrame window = new JFrame("Chess Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
//        window.getIconImage(logo.getImage());

        //Add Main.Main.GamePanel to the window
        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gp.lauchGame();
    }
}