package it.units.crossway.controller;

import it.units.crossway.config.Config;
import it.units.crossway.model.Board;

public class GameController implements Controller {
    private Board board;

    public GameController() {
        this.board = new Board(Config.N_ROWS, Config.N_COLUMNS);
    }

    public Board getBoard() {
        return this.board;
    }
}
