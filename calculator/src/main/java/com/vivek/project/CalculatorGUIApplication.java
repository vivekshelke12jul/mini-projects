package com.vivek.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Character.isDigit;

public class CalculatorGUIApplication implements ActionListener {
    JFrame frame;
    JTextField display;
    ExpressionEvaluator evaluator = new ExpressionEvaluator();


    public CalculatorGUIApplication(){

        // Display Panel
        JPanel dp = new JPanel();
        dp.setPreferredSize(new Dimension(500, 100));
        dp.setBackground(Color.LIGHT_GRAY);
        dp.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        dp.setLayout(new BorderLayout());

        display = new JTextField();
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
                "(", ")", "C", "<=",
                "1", "2", "3", "/",
                "4", "5", "6", "*",
                "7", "8", "9", "-",
                ".", "0", "=", "+",

        };

        for(String text: buttonText){
            JButton button = new JButton(text);
            button.setFont(new Font("Segoe UI", Font.PLAIN, 50));
            button.addActionListener(this);
            bp.add(button);
        }

        // JFrame
        frame = new JFrame();
        frame.setSize(new Dimension(500, 600));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.add(dp, BorderLayout.NORTH);
        frame.add(bp, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        System.out.println(actionCommand);
        // . ( ) are not being implemented now

        if(actionCommand.equals("C")){
            display.setText("");
        }else if(actionCommand.equals("<=")){
            String text = display.getText();
            if(text.isEmpty()){
                return;
            }
            display.setText(text.substring(0, text.length() - 1));
        }else if(actionCommand.equals("=")){
            String expression = display.getText();
            Double result = evaluator.evaluate(expression);
            display.setText(result.toString());
        }else if(isDigit(actionCommand.charAt(0))){
            display.setText(display.getText() + actionCommand);
        }else if(
                actionCommand.equals("+") ||
                actionCommand.equals("-") ||
                actionCommand.equals("*") ||
                actionCommand.equals("/")
        ){
            String text = display.getText();
            if(text.isEmpty()){
                return;
            }
            char lastChar = text.charAt(text.length() - 1);
            if(lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/'){
                String newText = text.substring(0, text.length()-1) + actionCommand;
                System.out.println(newText);
                display.setText(newText);
            }else{
                display.setText(display.getText() + actionCommand);
            }
        }
    }
}
