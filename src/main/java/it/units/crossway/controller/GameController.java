package it.units.crossway.controller;

import it.units.crossway.gui.PieceGui;
import it.units.crossway.model.Piece;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;

import java.awt.*;

public class GameController implements Controller {
    private Board board;
    private Color currentUserColor;

    public GameController(Board board) {
        this.board = board;
        currentUserColor = Color.BLACK;
        System.out.println("Game Starts!");
    }

    @Override
    public Color getCurrentColor() {
        return currentUserColor;
    }

    public Board getBoard() {return board;}

    /*This method asks the board if a position is playable
    * for a piece*/
    @Override
    public boolean canPlace(Coordinates position) {
        return board.canPlace(position, new Piece(currentUserColor));
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
        try {
            board.place(piece.getPosition(), new Piece(piece.getColor()));
        } catch (Exception e) {
            return Status.not_placed();
        }
        if (GameWon()) {
            /*End game*/
            return Status.won();
        } else {
            changeColor();
            return Status.placed();
        }

    }


}
