package it.units.crossway.gui;
import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {

    public Frame(String title, int width, int height, int x_location, int y_location, JPanel content) {
        this.setTitle(title);
        this.setLayout(new BorderLayout());
        this.getContentPane().add(content, BorderLayout.CENTER);
        this.setSize(new Dimension(width, height));
        this.setResizable(false);
        this.setLocation(x_location, y_location);




        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}