package it.units.crossway.controller;

import it.units.crossway.config.Config;
import it.units.crossway.model.Board;

public class GameController implements Controller {
    private Board board;
    public int p;

    public GameController() {
        this.board = new Board(Config.getN_Rows(), Config.getN_Columns());
    }

    public Board getBoard() {
        return this.board;
    }
}
