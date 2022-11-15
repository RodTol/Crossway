package it.units.crossway.controller;

import it.units.crossway.gui.PieceGui;
import it.units.crossway.model.Piece;
import it.units.crossway.utils.Config;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;

import java.awt.*;

public class GameController implements Controller {
    private Board board;
    private Color CurrentUserColor;

    public GameController() {
        this.board = new Board();
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

    /*Stessa roba di place. Metti pedina al posti di colore*/
    @Override
    public boolean canPlace(Color playerColor, Coordinates position) {

        return this.board.canPlace(position, Config.N_ROWS, Config.N_COLUMNS, playerColor);
    }

    /*Metti al posto di color una pieceGUi perche chiedi se puoi piazzare una pedina
    * un colore*/
    @Override
    public Status place(PieceGui piece, Coordinates position) {
        board.place(position, new Piece(piece.getColor()));
        if (board.isWin()) {
            return Status.won();
        } else {
            return Status.placed();
        }

    }


}
