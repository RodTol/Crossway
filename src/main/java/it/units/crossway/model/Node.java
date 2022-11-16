package it.units.crossway.model;

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

    public boolean isNodeEmpty(){
        if (this.piece == null){
            return true;
        }
        else {
            return false;
        }
    }

}
