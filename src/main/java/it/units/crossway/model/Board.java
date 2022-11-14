package it.units.crossway.model;


import java.awt.*;

public class Board {

    /*Matrix of Nodes*/
    private Node[][] nodes;

    public Board(int NRows, int NColumns) {
        this.nodes = new Node[NRows][NColumns];
        for (int row = 0; row < nodes.length; row++) {
            for (int col = 0; col < nodes[row].length; col++) {
                nodes[row][col] = new Node();
            }
        }
    }

    public Node[][] getNodes() {
        return nodes;
    }

    public boolean canPlace(int r, int c, int NRows, int NColumns, Color playerColor) {
        if (!nodes[r-1][c-1].isNodeEmpty() && nodes[r-1][c-1].getPiece().color == playerColor) {
            if (!nodes[r-1][c].isNodeEmpty() && !nodes[r][c-1].isNodeEmpty() &&
                    nodes[r-1][c].getPiece().color == nodes[r][c-1].getPiece().color &&
                    nodes[r-1][c].getPiece().color != playerColor) {
                return false;
            }
        }
        if (!nodes[r-1][c+1].isNodeEmpty() && nodes[r-1][c+1].getPiece().color == playerColor) {
            if (!nodes[r-1][c].isNodeEmpty() && !nodes[r][c+1].isNodeEmpty() &&
                    nodes[r-1][c].getPiece().color == nodes[r][c+1].getPiece().color &&
                    nodes[r-1][c].getPiece().color != playerColor) {
                return false;
            }
        }
        if (!nodes[r+1][c-1].isNodeEmpty() && nodes[r+1][c-1].getPiece().color == playerColor) {
            if (!nodes[r][c-1].isNodeEmpty() && !nodes[r+1][c].isNodeEmpty() &&
                    nodes[r][c-1].getPiece().color == nodes[r+1][c].getPiece().color &&
                    nodes[r][c-1].getPiece().color != playerColor) {
                return false;
            }
        }
        if (!nodes[r+1][c+1].isNodeEmpty() && nodes[r+1][c+1].getPiece().color == playerColor) {
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
