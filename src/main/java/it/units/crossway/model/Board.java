package it.units.crossway.model;


import javax.swing.text.Position;
import java.awt.*;

public class Board {

    /*Creation of matrices of references of NOde type*/
    private Piece[][] pieces;

    public Board(int Nrows, int Ncolumns) {
        this.pieces = new Piece[Nrows][Ncolumns];
    }

    public boolean getNodePlayable(int r, int c) {
        return true;
    }

    public boolean canPlace(Color color, PiecePosition position) {
        return true;
    }
}
