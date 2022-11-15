package it.units.crossway.controller;

import it.units.crossway.gui.PieceGui;
import it.units.crossway.model.Piece;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;

import java.awt.*;

public class GameController implements Controller {
    private Board board;
    private Color currentUserColor;

    public GameController() {
        board = new Board();
        currentUserColor = Color.BLACK;
        System.out.println("Game Starts!");
    }

    @Override
    public Board getBoard() {
        return this.board;
    }

    @Override
    public Color getCurrentColor() {
        return this.currentUserColor;
    }

    /*This method asks the board if a position is playable
    * for a piece*/
    @Override
    public boolean canPlace(Color playerColor, Coordinates position) {
        return board.canPlace(position, new Piece(playerColor));
    }

    private boolean GameWon() {
        return board.isWin();
    }

    private void changeColor() {
        if (currentUserColor.equals(Color.BLACK)) {
            currentUserColor = Color.WHITE;
        } else {
            currentUserColor = Color.BLACK;
        }
    }

    /*This method place a piece on the board from the input of the Gui. Then
    * checks if the Game is finished, and if it's the case can make something*/
    @Override
    public Status place(PieceGui piece) {
        board.place(piece.getPosition(), new Piece(piece.getColor()));
        if (GameWon()) {
            /*End game*/
            return Status.won();
        } else {
            changeColor();
            return Status.placed();
        }

    }


}
