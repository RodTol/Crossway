package it.units.crossway.launcher;

import it.units.crossway.gui.BoardPanelSettings;
import it.units.crossway.gui.GameGui;
import it.units.crossway.model.Board;
import it.units.crossway.controller.Controller;
import it.units.crossway.controller.GameController;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(Config.N_ROWS, Config.N_COLUMNS);
        Controller controller = new GameController(board);
        GameGui gameGui = new GameGui(controller, new BoardPanelSettings(Config.BOARD_MARGIN,
                Config.BOARD_HEIGHT, Config.BOARD_WIDTH, Config.CELL_SIZE));
        System.out.println("Game Starts!");
    }

}




