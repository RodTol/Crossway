package it.units.crossway.controller;

import it.units.crossway.gui.PieceGui;
import it.units.crossway.model.Piece;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;

import java.awt.*;

public class GameController implements Controller {
    private Board board;
    // private WinEvaluator winEvaluator;
    private Player player1;
    private Player player2;
    private Player currentPlayer;


    public GameController(Board board) {
        this.board = board;
        player1 = new Player(1, Color.BLACK);
        player2 = new Player(2, Color.WHITE);
        currentPlayer = player1;
        System.out.println("Game Starts!");
    }

    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    @Override
    public Board getBoard() {return board;}

    public String getWhiteName() {
        if (player1.getColor().equals(Color.WHITE)) {
            return player1.getName();
        } else {
            return player2.getName();

        }
    }

    public String getBlackName() {
        if (player1.getColor().equals(Color.BLACK)) {
            return player1.getName();
        } else {
            return player2.getName();

        }
    }

    @Override
    public void setNameWhitePlayer(String name) {
        this.player2.setName(name);
    }
    @Override
    public void setNameBlackPlayer(String name) {
        this.player1.setName(name);
    }
    @Override
    public Player getPlayer1() {
        return player1;
    }
    @Override
    public Player getPlayer2() {
        return player2;
    }

    /*This method asks the board if a position is playable
    * for a piece*/
    @Override
    public boolean canPlace(Coordinates position) {
        return board.canPlace(position, new Piece(currentPlayer.getColor()));
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
        WinController winController = new WinController(board, piece.getColor());
        if (winController.check()) {
            System.out.println("GAME WON!");
            return Status.won();
        } else {
            changeTurn();
            System.out.println("Piece placed in row:" + piece.getPosition().getRow()
                    + " column: " + piece.getPosition().getColumn() );
            return Status.placed();
        }

    }

    private void changeTurn() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

}
