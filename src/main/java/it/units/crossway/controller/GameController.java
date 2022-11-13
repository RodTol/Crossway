package it.units.crossway.controller;

import it.units.crossway.model.Piece;
import it.units.crossway.utils.Config;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;

import java.awt.*;

public class GameController implements Controller {
    private Board board;
    private Color CurrentUserColor;

    public GameController() {
        this.board = new Board(Config.N_ROWS, Config.N_COLUMNS);
        this.CurrentUserColor = Color.BLACK;
    }

    @Override
    public Board getBoard() {
        return this.board;
    }

    @Override
    public Color getCurrentColor() {
        return this.CurrentUserColor;
    }

    @Override
    public boolean canPlace(Color playerColor, Coordinates position) {
        return true;
    }

    @Override
    public boolean place(Color playerColor, Coordinates position) {
        try {
            board.place(position, new Piece(playerColor));
        } catch (Exception e) {
            return false;
        }
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
