package it.units.crossway.model;


import java.awt.*;

public class Board {

    /*Matrix of Nodes*/
    private Node[][] nodes;

    public Board(int NRows, int NColumns) {
        this.nodes = new Node[NRows][NColumns];
        for (int row = 0; row < nodes.length; row++) {
            for (int col = 0; col < nodes[row].length; col++) {
                //se volete qua si possono creare le coordinate e usare quelle ma a me sembra strano
                nodes[row][col] = new Node();
            }
        }
    }

    public Node[][] getNodes() {
        return nodes;
    }

    public boolean canPlace(Coordinates coordinates, int NRows, int NColumns, Color playerColor) {
        int r = coordinates.getRow();
        int c = coordinates.getColumn();

        if (r!=0 && c!=0 && !nodes[r-1][c-1].isNodeEmpty() && nodes[r-1][c-1].getPiece().color == playerColor) {
            if (!nodes[r-1][c].isNodeEmpty() && !nodes[r][c-1].isNodeEmpty() &&
                    nodes[r-1][c].getPiece().color == nodes[r][c-1].getPiece().color &&
                    nodes[r-1][c].getPiece().color != playerColor) {
                return false;
            }
        }
        if (r!=0 && c!=NColumns-1 && !nodes[r-1][c+1].isNodeEmpty() && nodes[r-1][c+1].getPiece().color == playerColor) {
            if (!nodes[r-1][c].isNodeEmpty() && !nodes[r][c+1].isNodeEmpty() &&
                    nodes[r-1][c].getPiece().color == nodes[r][c+1].getPiece().color &&
                    nodes[r-1][c].getPiece().color != playerColor) {
                return false;
            }
        }
        if (c!=0 && r!=NRows-1 && !nodes[r+1][c-1].isNodeEmpty() && nodes[r+1][c-1].getPiece().color == playerColor) {
            if (!nodes[r][c-1].isNodeEmpty() && !nodes[r+1][c].isNodeEmpty() &&
                    nodes[r][c-1].getPiece().color == nodes[r+1][c].getPiece().color &&
                    nodes[r][c-1].getPiece().color != playerColor) {
                return false;
            }
        }
        if (r!=NRows-1 && c!=NColumns-1 && !nodes[r+1][c+1].isNodeEmpty() && nodes[r+1][c+1].getPiece().color == playerColor) {
            if (!nodes[r][c+1].isNodeEmpty() && !nodes[r+1][c].isNodeEmpty() &&
                    nodes[r][c+1].getPiece().color == nodes[r+1][c].getPiece().color &&
                    nodes[r][c+1].getPiece().color != playerColor) {
                return false;
            }
        }
        return true;
    }

    public void place(Coordinates c, Piece piece) {
        nodes[c.getRow()][c.getColumn()].setPiece(piece);
    }

}
