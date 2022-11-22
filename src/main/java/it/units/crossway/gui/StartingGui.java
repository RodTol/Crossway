package it.units.crossway.gui;

import it.units.crossway.controller.Controller;
import it.units.crossway.launcher.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class StartingGui extends JPanel {
    private final Controller controller;
    private JTextField whitePLayerName = new JTextField(20);
    private JTextField blackPlayerName = new JTextField(20);
    private JButton letSPlayButton = new JButton("Let's Play!");
    private JButton clearButton = new JButton("Clear");

    private JLabel white = new JLabel("White Player Name");
    private JLabel black = new JLabel("Black Player Name");
    private JLabel warning = new JLabel("Insert valid name!");

    public StartingGui(Controller controller) {
        this.controller = controller;

        this.setLayout(null);

        white.setBounds(10,20,150, 25);
        this.add(white);
        whitePLayerName.setBounds(180, 20, 200, 25);
        this.add(whitePLayerName);
        black.setBounds(10,50,150, 25);
        this.add(black);
        blackPlayerName.setBounds(180, 50, 200, 25);
        this.add(blackPlayerName);
        letSPlayButton.setBounds(10, 100, 170, 30 );
        letSPlayButton.addActionListener(new letsPlayListener());
        this.add(letSPlayButton);
        clearButton.setBounds(210, 100, 170, 30 );
        clearButton.addActionListener(new clearListener());
        this.add(clearButton);
        warning.setBounds(130, 140, 200, 25);
        warning.setForeground(Color.RED);

        whitePLayerName.setHorizontalAlignment(JTextField.CENTER);
        blackPlayerName.setHorizontalAlignment(JTextField.CENTER);

    }

    void handleLetSPlay(String white_name, String black_name) {
        if (Objects.equals(white_name, "") || Objects.equals(black_name, "")) {
            this.add(warning);
            repaint();
        } else {
            controller.setNameWhitePlayer(white_name);
            controller.setNameBlackPlayer(black_name);
            JFrame parent = (JFrame) this.getTopLevelAncestor();
            parent.dispose();
        }
    }

    void handleClear() {
        whitePLayerName.setText("");
        blackPlayerName.setText("");
    }

    private class letsPlayListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            handleLetSPlay(whitePLayerName.getText(), blackPlayerName.getText());
        }
    }

    private class clearListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            handleClear();
        }
    }



}
