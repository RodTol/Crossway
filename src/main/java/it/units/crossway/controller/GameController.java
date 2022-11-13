package it.units.crossway.controller;

import it.units.crossway.config.Config;
import it.units.crossway.model.Board;
import it.units.crossway.model.PiecePosition;

import java.awt.*;

public class GameController implements Controller {
    private Board board;
    private Color currentColor;

    public GameController() {
        this.board = new Board(Config.N_ROWS, Config.N_COLUMNS);
        this.currentColor = Color.BLACK;
    }

    @Override
    public Board getBoard() {
        return this.board;
    }

    @Override
    public Color getCurrentColor() {
        return this.currentColor;
    }

    @Override
    public boolean canPlace(Color playerColor, PiecePosition position) {
        return true;
    }

    @Override
    public boolean place(Color playerColor, PiecePosition position) {
        return true;
    }

    @Override
    public void changeTurn() {
        if (this.currentColor == Color.WHITE) {
            this.currentColor = Color.BLACK;
        } else if (this.currentColor == Color.BLACK) {
            this.currentColor = Color.WHITE;
        }
    }


}
