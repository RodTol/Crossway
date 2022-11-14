package it.units.crossway.model;


import java.awt.*;

public class Board {

    /*Matrix of Pieces*/
    private Node[][] nodes;

    public Board(int Nrows, int Ncolumns) {
        this.nodes = new Node[Nrows][Ncolumns];
    }

    public boolean isNodePlayable(int r, int c) {
        /*Controllo 8 pedine attorno per capire se giocabile*/
        return true;
    }

    public void place(Coordinates c, Piece piece) {
        nodes[c.getRow()][c.getColumn()] = new Node();
        nodes[c.getRow()][c.getColumn()].setPiece(piece);
    }

    public boolean canPlace(Color color, Coordinates position) {
        return true;
    }

    public boolean isWin() {
        return false;
    }
}
