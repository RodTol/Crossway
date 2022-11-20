package it.units.crossway.controller;

import it.units.crossway.model.Board;
import it.units.crossway.utilities.Graph;

import java.awt.*;

public class WinController {
    private final Board board;
    private final Color color;

    public WinController(Board board, Color color) {
        this.board = board;
        this.color = color;
    }

    /*Non puoi accedere ai dati della board, ma solo
     * chiamare i suoi metodi.
     * Quindi fai tipo has at least e haspiece in row(index of row)*/
    public boolean check() {
        if (!minNofPieces()) {
            return false;
        }

        if (color.equals(Color.BLACK)) {
            return blackCheck();
        } else {
            return whiteCheck();
        }
    }

    boolean minNofPieces() {
        return board.NumbOfPieces(color) >= board.getNodes().length;
    }

    boolean blackCheck() {
        for (int i = 0; i < board.getNodes().length; i++) {
            if (!board.hasAtLeastOneInRow(i, color)) {
                return false;
            }
        }

        Graph graph = board.toGraph(color);

        return true;
    }

    boolean whiteCheck() {
        for (int i = 0; i < board.getNodes().length; i++) {
            if (!board.hasAtLeastOneinColumn(i, color)) {
                return false;
            }
        }

        Graph graph = board.toGraph(color);

        return true;
    }


}
