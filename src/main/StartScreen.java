package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartScreen extends JPanel {
    public StartScreen(ActionListener onNormal, ActionListener onChess960) {
        setLayout(new GridBagLayout());
        JButton normalBtn = new JButton("Normal Chess");
        JButton chess960Btn = new JButton("Chess-960");

        normalBtn.addActionListener(onNormal);
        chess960Btn.addActionListener(onChess960);

        add(normalBtn);
        add(chess960Btn);
    }
}