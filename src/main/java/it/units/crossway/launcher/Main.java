package it.units.crossway.launcher;

import it.units.crossway.gui.BoardGuiSettings;
import it.units.crossway.model.Board;
import it.units.crossway.controller.Controller;
import it.units.crossway.controller.GameController;
import it.units.crossway.gui.BoardGui;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Board board = new Board( Config.N_ROWS, Config.N_COLUMNS);
        Controller controller = new GameController(board);
        BoardGui boardGui = new BoardGui(controller, new BoardGuiSettings(Config.BOARD_MARGIN, Config.BOARD_HEIGHT, Config.BOARD_WIDTH, Config.CELL_SIZE));
        boardGui.setBackground(Color.LIGHT_GRAY);
        JFrame frame = new JFrame();
        frame.setTitle("Crossway");
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(boardGui, BorderLayout.CENTER);
        frame.setSize(new Dimension(Config.FRAME_WIDTH, Config.FRAME_HEIGHT));
        frame.setLocation(500, 200);    // location where frame appears
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
