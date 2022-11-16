package it.units.crossway.model;
import java.awt.*;
import java.util.stream.Stream;

public class Board {

    /*Matrix of Nodes*/
    private Node[][] nodes;

    /*If we want we can use streams*/
    public Board(int nRows, int nColumns) {
        nodes = new Node[nRows][nColumns];
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nColumns; c++) {
                nodes[r][c] = new Node();
            }
        }
    }

    public Node[][] getNodes() {
        return nodes;
    }

    public Node getNode(Coordinates c) {return nodes[c.getRow()][c.getColumn()];}


    public boolean canPlace(Coordinates coordinates, Piece piece) {
        int nRows = nodes.length;
        int nColums = nodes[0].length;

        int r = coordinates.getRow();
        int c = coordinates.getColumn();
        Color playerColor = piece.getColor();

        if (!nodes[r][c].isNodeEmpty()) {
            return false;
        }

        if (r!=0 && c!=0 && !nodes[r-1][c-1].isNodeEmpty() && nodes[r - 1][c - 1].getPiece().getColor() == playerColor) {
            if (!nodes[r-1][c].isNodeEmpty() && !nodes[r][c-1].isNodeEmpty() &&
                    nodes[r - 1][c].getPiece().getColor() == nodes[r][c - 1].getPiece().getColor() &&
                    nodes[r - 1][c].getPiece().getColor() != playerColor) {
                return false;
            }
        }
        if (r!=0 && c!=nColums-1 && !nodes[r-1][c+1].isNodeEmpty() && nodes[r - 1][c + 1].getPiece().getColor() == playerColor) {
            if (!nodes[r-1][c].isNodeEmpty() && !nodes[r][c+1].isNodeEmpty() &&
                    nodes[r - 1][c].getPiece().getColor() == nodes[r][c + 1].getPiece().getColor() &&
                    nodes[r - 1][c].getPiece().getColor() != playerColor) {
                return false;
            }
        }
        if (c!=0 && r!=nRows-1 && !nodes[r+1][c-1].isNodeEmpty() && nodes[r + 1][c - 1].getPiece().getColor() == playerColor) {
            if (!nodes[r][c-1].isNodeEmpty() && !nodes[r+1][c].isNodeEmpty() &&
                    nodes[r][c - 1].getPiece().getColor() == nodes[r + 1][c].getPiece().getColor() &&
                    nodes[r][c - 1].getPiece().getColor() != playerColor) {
                return false;
            }
        }
        if (r!=nRows-1 && c!=nColums-1 && !nodes[r+1][c+1].isNodeEmpty() &&
                nodes[r + 1][c + 1].getPiece().getColor() == playerColor) {
            if (!nodes[r][c+1].isNodeEmpty() && !nodes[r+1][c].isNodeEmpty() &&
                    nodes[r][c + 1].getPiece().getColor() == nodes[r + 1][c].getPiece().getColor() &&
                    nodes[r][c + 1].getPiece().getColor() != playerColor) {
                return false;
            }
        }
        return true;
    }

    public void place(Coordinates c, Piece piece) {
        nodes[c.getRow()][c.getColumn()] = new Node();
        nodes[c.getRow()][c.getColumn()].setPiece(piece);
    }

    public boolean isWin() {
        /*If condition to exit before the winning analysis
        * like: at least 19 pieces, at least one piece in row 0
        * and row 19 for black*/
        /*Create graphs. Only when necessary*/
        /*Check graphs for winning*/
        return false;
    }
}
