package it.units.crossway.gui;

import it.units.crossway.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class StartingGui extends JPanel {
    private final Controller controller;
    private JTextField white = new JTextField(20);
    private JTextField black = new JTextField(20);

    private JButton button = new JButton("Let's Play!");

    public StartingGui(Controller controller) {
        this.controller = controller;
        this.add(white);
        //this.add(black);
        white.setHorizontalAlignment(JTextField.CENTER);
        black.setHorizontalAlignment(JTextField.CENTER);

        white.setToolTipText("WHITE PLAYER");
        black.setToolTipText("BLACK PLAYER");

        white.setFont(new java.awt.Font("Arial", Font.ITALIC | Font.BOLD, 20));
        black.setFont(new java.awt.Font("Arial", Font.ITALIC | Font.BOLD, 20));

        //button.addActionListener();

    }

}
