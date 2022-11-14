package it.units.crossway.model;

import it.units.crossway.exceptions.NullPieceException;

import java.awt.*;

public class Node {
    private Piece piece;

    public Node() {
        piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean hasPiece() {
        if (piece == null) {
            return false;
        } else {
            return true;
        }
    }

}
