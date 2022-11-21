package it.units.crossway.launcher;

import it.units.crossway.gui.BoardGuiSettings;
import it.units.crossway.gui.StartingGui;
import it.units.crossway.model.Board;
import it.units.crossway.controller.Controller;
import it.units.crossway.controller.GameController;
import it.units.crossway.gui.BoardGui;

import javax.swing.*;
import java.awt.*;

public class Main {

    private static void createWindow(String title,  int width, int height, JPanel content) {
        JFrame frame = new JFrame(title);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(content, BorderLayout.CENTER);
        frame.setSize(new Dimension(width, height));
        frame.setLocation(500, 200);    // location where frame appears
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        Board board = new Board( Config.N_ROWS, Config.N_COLUMNS);
        Controller controller = new GameController(board);

        StartingGui startingGui = new StartingGui(controller);
        startingGui.setBackground(Color.LIGHT_GRAY);
        createWindow("Player selection", 500, 500, startingGui);

        BoardGui boardGui = new BoardGui(controller, new BoardGuiSettings(Config.BOARD_MARGIN, Config.BOARD_HEIGHT, Config.BOARD_WIDTH, Config.CELL_SIZE));
        boardGui.setBackground(Color.LIGHT_GRAY);
        createWindow("Crossway", Config.FRAME_WIDTH, Config.FRAME_HEIGHT, boardGui);

    }
}
