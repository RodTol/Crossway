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
                System.out.println("File created: " + log.getName());
            } else {
                PrintWriter writer = new PrintWriter(log);
                writer.print("");
                writer.close();
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

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

    public static String getColorName(Color color) {
       if (color.equals(Color.BLACK)) {
           return "Black";
       }
       else {
           return "White";
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
        WinController winController = new WinController(board, piece.getColor());
        if (winController.check()) {
            System.out.println("GAME WON!");
            return Status.won();
        } else {
            String text = "Player " + getCurrentPlayer().getId() + " placed a " + getColorName(piece.getColor()) +
                    " piece at (" + piece.getPosition().getColumn() + ", " + piece.getPosition().getRow() + ")\n";

            try {
                FileWriter output = new FileWriter(log.getPath(), true);
                output.write(text);
                output.close();
            } catch (Exception e) {
                e.getStackTrace();
            }

            changeTurn();
            return Status.placed();
        }

    }

    @Override
    public void reset() {
        board.reset();
    }

    private void changeTurn() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
        if (!atLeastOnePlacement()){
            changeTurn();
        }
    }

    private void usePieRule(){
        player1.setColor(Color.WHITE);
        player2.setColor(Color.BLACK);
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
