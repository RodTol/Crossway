package it.units.crossway.controller;

import it.units.crossway.model.Board;

import java.awt.*;

public class WinController {
    private Board board;
    private Color color;

    public WinController(Board board, Color color) {
        this.board = board;
        this.color = color;
    }


    public boolean check() {
        if (color.equals(Color.BLACK)) {
            /*Non puoi accedere ai dati della board, ma solo
            * chiamare i suoi metodi.
            * Quindi fai tipo has at least e haspiece in row(index of row)*/
        }
        return false;
    }
}
