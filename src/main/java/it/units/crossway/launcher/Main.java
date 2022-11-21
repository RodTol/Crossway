package it.units.crossway.launcher;

import it.units.crossway.gui.BoardGuiSettings;
import it.units.crossway.gui.StartingGui;
import it.units.crossway.model.Board;
import it.units.crossway.controller.Controller;
import it.units.crossway.controller.GameController;
import it.units.crossway.gui.BoardGui;

import javax.swing.*;
import java.awt.*;

public class    Main {
    public static void main(String[] args) {
        Board board = new Board( Config.N_ROWS, Config.N_COLUMNS);
        Controller controller = new GameController(board);

        //StartingGui startingGui = new StartingGui(controller);
        //Window start

        BoardGui boardGui = new BoardGui(controller, new BoardGuiSettings(Config.BOARD_MARGIN, Config.BOARD_HEIGHT, Config.BOARD_WIDTH, Config.CELL_SIZE));
        boardGui.setBackground(Color.LIGHT_GRAY);
        Window game = new Window("Crossway", boardGui, Config.FRAME_WIDTH, Config.FRAME_HEIGHT);

    }
}
