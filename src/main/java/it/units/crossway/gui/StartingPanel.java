package it.units.crossway.gui;

import it.units.crossway.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class StartingPanel extends JPanel {
    private final Controller controller;
    private final JTextField whitePLayerName = new JTextField(20);
    private final JTextField blackPlayerName = new JTextField(20);
    private final JButton letSPlayButton = new JButton("Let's Play!");
    private final JButton clearButton = new JButton("Clear");
    private final JButton demoButton = new JButton("Play Demo");
    private final JLabel warning = new JLabel("Insert valid name!");
    boolean warningLabelOn = false;

    public StartingPanel(Controller controller) {
        this.controller = controller;

        this.setLayout(null);

        JLabel white = new JLabel("White Player Name");
        white.setBounds(10,20,150, 25);
        this.add(white);

        whitePLayerName.setBounds(180, 20, 200, 25);
        this.add(whitePLayerName);

        JLabel black = new JLabel("Black Player Name");
        black.setBounds(10,50,150, 25);
        this.add(black);

        blackPlayerName.setBounds(180, 50, 200, 25);
        this.add(blackPlayerName);

        letSPlayButton.setBounds(10, 100, 120, 30 );
        this.add(letSPlayButton);

        demoButton.setBounds(140, 100, 120, 30);
        this.add(demoButton);

        clearButton.setBounds(270, 100, 120, 30 );
        this.add(clearButton);

        warning.setBounds(130, 140, 200, 25);
        warning.setForeground(Color.RED);

        whitePLayerName.setHorizontalAlignment(JTextField.CENTER);
        blackPlayerName.setHorizontalAlignment(JTextField.CENTER);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 180);
    }
    public JButton getLetSPlayButton() {
        return letSPlayButton;
    }
    public JButton getDemoButton() {return demoButton;}
    public JButton getClearButton() {
        return clearButton;
    }

    boolean handleLetSPlay() {
        String white_name = whitePLayerName.getText();
        String black_name = blackPlayerName.getText();
        if (Objects.equals(white_name, "") || Objects.equals(black_name, "")) {
            this.add(warning);
            warningLabelOn = true;
            repaint();
            return false;
        } else {
            if (warningLabelOn) {
                this.remove(warning);
                warningLabelOn = false;
            }
            controller.setNameWhitePlayer(white_name);
            controller.setNameBlackPlayer(black_name);
            return true;
        }
    }

    void handleClear() {
        whitePLayerName.setText("");
        blackPlayerName.setText("");
    }

}
