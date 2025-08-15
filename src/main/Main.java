package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Chess Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        // Start screen
        StartScreen startScreen = new StartScreen(
                e -> startGame(window, false),
                e -> startGame(window, true)
        );
        window.add(startScreen);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private static void startGame(JFrame window, boolean chess960) {
        window.getContentPane().removeAll();
        GamePanel gp = new GamePanel(chess960);
        window.add(gp);
        window.pack();
        gp.lauchGame();
        window.revalidate();
        window.repaint();
    }
}