package it.units.crossway.controller;

import it.units.crossway.config.Config;
import it.units.crossway.model.Board;

public class GameController {
    private Board board;

    public GameController() {
        this.board = new Board(Config.getN_Rows(), Config.getN_Columns());
    }
}
