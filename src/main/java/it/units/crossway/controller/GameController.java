package it.units.crossway.controller;

import it.units.crossway.model.Board;

public class GameController implements Controller {
    private Board board;
    public int p;

    public GameController() {
        this.board = new Board();
    }

    public Board getBoard() {
        return this.board;
    }
}
