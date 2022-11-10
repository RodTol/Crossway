package it.units.crossway.model;

public class Node {
    //coordinates of the node
    public int x;
    public int y;
    //piece on the node
    public Piece piece = null;
    //boolean which identifies if the player can place a piece on this node
    public boolean playable = true;


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isPlayable() {
        return playable;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }
}
