package it.units.crossway.gui;

import it.units.crossway.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class WinnerPanel extends JPanel {
    private final Controller controller;
    private JLabel congratulations = new JLabel();

    public WinnerPanel(Controller controller) {
        this.controller = controller;
        congratulations.setBounds(10,30,280,25);
        this.setLayout(null);
        this.add(congratulations);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 100);
    }

    void setCongratulations() {
        congratulations.setText("Congratulation " + controller.getCurrentPlayer().getName() + "! You have won!");
    }

}
