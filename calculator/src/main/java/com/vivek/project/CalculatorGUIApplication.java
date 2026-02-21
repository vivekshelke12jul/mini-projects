package com.vivek.project;

import javax.swing.*;
import java.awt.*;

public class CalculatorGUIApplication {

    public CalculatorGUIApplication(){

        // Display Panel
        JPanel dp = new JPanel();
        dp.setPreferredSize(new Dimension(500, 100));
        dp.setBackground(Color.LIGHT_GRAY);
        dp.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        dp.setLayout(new BorderLayout());

        JTextField display = new JTextField();
        display.setFont(new Font("Segoe UI", Font.PLAIN, 50));
        display.setHorizontalAlignment(SwingConstants.RIGHT);

        dp.add(display, BorderLayout.CENTER);

        // Buttons Panel
        JPanel bp = new JPanel();

        bp.setPreferredSize(new Dimension(100, 500));
        bp.setBackground(Color.LIGHT_GRAY);
        bp.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        bp.setLayout(new GridLayout(5,4, 5,5));

        String[] buttonText = new String[]{
                "( )", ")", "C", "<=",
                "1", "2", "3", "/",
                "4", "5", "6", "*",
                "7", "8", "9", "-",
                ".", "0", "=", "+",

        };

        for(String text: buttonText){
            JButton button = new JButton(text);
            button.setFont(new Font("Segoe UI", Font.PLAIN, 50));
            bp.add(button);
        }

        // JFrame
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500, 600));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.add(dp, BorderLayout.NORTH);
        frame.add(bp, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
