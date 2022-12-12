package it.units.crossway.controller;

import it.units.crossway.gui.PieceGui;
import it.units.crossway.model.Piece;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GameController implements Controller {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private File log;


    public GameController(Board board) {
        this.board = board;
        player1 = new Player(1, Color.BLACK);
        player2 = new Player(2, Color.WHITE);
        currentPlayer = player1;
        try {
            log = new File("log.txt");
            if (log.createNewFile()) {
                System.out.println("Log created: " + log.getName());
            } else {
                PrintWriter writer = new PrintWriter(log);
                writer.print("");
                writer.close();
                System.out.println("File log.txt already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred during the creation/access to the file.");
            e.printStackTrace();
        }
    }

    @Override
    public Board getBoard() {return board;}
    @Override
    public Player getPlayer1() {
        return player1;
    }
    @Override
    public Player getPlayer2() {
        return player2;
    }
    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    @Override
    public void setNameWhitePlayer(String name) {
        this.player2.setName(name);
    }
    @Override
    public void setNameBlackPlayer(String name) {
        this.player1.setName(name);
    }


    /*This method asks the board if a position is playable
    * for a piece*/
    @Override
    public boolean canPlace(Coordinates position) {
        return board.canPlace(position, new Piece(currentPlayer.getColor()));
    }

    /*This method places a piece on the board from the input of the Gui. Then
     * checks if the Game is finished.*/
    @Override
    public Condition place(PieceGui piece) {
        try {
            board.place(piece.getPosition(), new Piece(piece.getColor()));
        } catch (Exception e) {
            return Condition.NOT_PLACED;
        }

        WinRuler winRuler = new WinRuler(board, piece.getColor());

        if (winRuler.winCheck()) {
            System.out.println("Game Won!");
            String text = "Game won by player " + getCurrentPlayer().getId() + " with color " + getCurrentPlayer().colorToString() + "\n" +
                    "The winner piece is placed at (" + piece.getPosition().getColumn() + ", " + piece.getPosition().getRow() + ")\n" +
                    "-----------------------------\n";;
            try {
                FileWriter output = new FileWriter(log.getPath(), true);
                output.write(text);
                output.close();
            } catch (Exception e) {
                e.getStackTrace();
            }
            return Condition.WON;
        } else {
            String text = "Player " + getCurrentPlayer().getId() + " placed a " + Piece.colorToString(piece.getColor()) +
                    " piece at (" + piece.getPosition().getColumn() + ", " + piece.getPosition().getRow() + ")\n";

            try {
                FileWriter output = new FileWriter(log.getPath(), true);
                output.write(text);
                output.close();
            } catch (Exception e) {
                e.getStackTrace();
            }

            changeTurn();
            return Condition.PLACED;
        }
    }

    @Override
    public void resetGame() {
        board.emptyBoard();
        currentPlayer = player1;
        player1.setColor(Color.BLACK);
        player2.setColor(Color.WHITE);
    }

    @Override
    public void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private void changeTurn() {
        switchCurrentPlayer();
        if (!atLeastOnePlacement()){
            changeTurn();
        }
    }

    boolean atLeastOnePlacement(){
        for(int i=0; i<board.getNodes().length; i++) {
            for(int j=0; j<board.getNodes()[i].length; j++) {
                if (board.canPlace(new Coordinates(i,j),new Piece(currentPlayer.getColor()))){
                    return true;
                }
            }
        }
        return false;
    }

    public void applyPieRule() {
        player1.setColor(Color.white);
        player2.setColor(Color.black);
        changeTurn();
    }

}
