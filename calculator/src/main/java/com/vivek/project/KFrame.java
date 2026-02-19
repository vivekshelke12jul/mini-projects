package com.vivek.project;

import javax.swing.*;

public class KFrame extends JFrame {
    private int WIDTH = 600;
    private int HEIGHT = 800;


    public KFrame(){
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
