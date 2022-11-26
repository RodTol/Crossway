package it.units.crossway.gui;

import it.units.crossway.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class WinnerPanel extends JPanel {
    private final Controller controller;
    private final JLabel congratulations = new JLabel();
    private final JButton rematch = new JButton("Rematch");
    private final JButton close = new JButton("Close");

    public WinnerPanel(Controller controller) {
        this.controller = controller;

        this.setLayout(null);

        congratulations.setBounds(10,15,280,50);
        congratulations.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(congratulations);
        rematch.setBounds(10,80, 120,30);
        this.add(rematch);
        close.setBounds(160,80, 120,30);
        this.add(close);
    }

    public JButton getRematch() {
        return rematch;
    }

    public JButton getClose() {
        return close;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 130);
    }

    void setCongratulations() {
        congratulations.setText("<html>Congratulations " + controller.getCurrentPlayer().getName() + "! You have won!</html>");
    }

}
