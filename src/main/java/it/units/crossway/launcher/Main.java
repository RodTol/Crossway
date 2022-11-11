package it.units.crossway.launcher;

import it.units.crossway.config.Config;
import it.units.crossway.controller.Controller;
import it.units.crossway.controller.GameController;
import it.units.crossway.gui.BoardGui;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Controller controller = new GameController();
        BoardGui boardGui = new BoardGui(controller);

        JFrame frame = new JFrame();
        frame.setTitle("Crossway");
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(boardGui, BorderLayout.CENTER);
        frame.setSize(new Dimension(Config.getFrameWidth(), Config.getFrameHeight()));
        frame.setLocation(500, 200);    // location where frame appears
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
