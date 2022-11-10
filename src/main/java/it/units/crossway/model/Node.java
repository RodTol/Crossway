package it.units.crossway.model;

public class Node {
    //coordinates of the node
    private int r;
    private int c;
    //piece on the node
    private Piece piece;
    //boolean which identifies if the player can place a piece on this node
    private boolean playable;

    public Node(int row, int col) {
        r = row;
        c = col;
        piece = null;
        playable = true;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isPlayable() {
        return playable;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }
}
