package it.units.crossway.model;


import it.units.crossway.utils.Config;

import java.awt.*;
import java.util.stream.Stream;

public class Board {

    /*Matrix of Nodes*/
    private Node[][] nodes = new Node[Config.N_ROWS][Config.N_COLUMNS];

    /*If we want we can use streams*/
    public Board() {
        for (int r = 0; r < Config.N_ROWS; r++) {
            for (int c = 0; c < Config.N_COLUMNS; c++) {
                nodes[r][c] = new Node();
            }
        }
    }

    public Node[][] getNodes() {
        return nodes;
    }

    public Node getNode(Coordinates c) {return nodes[c.getRow()][c.getColumn()];}


    public boolean canPlace(Coordinates coordinates, Piece piece) {
        int r = coordinates.getRow();
        int c = coordinates.getColumn();
        Color playerColor = piece.getColor();

        if (r!=0 && c!=0 && !nodes[r-1][c-1].isNodeEmpty() && nodes[r - 1][c - 1].getPiece().getColor() == playerColor) {
            if (!nodes[r-1][c].isNodeEmpty() && !nodes[r][c-1].isNodeEmpty() &&
                    nodes[r - 1][c].getPiece().getColor() == nodes[r][c - 1].getPiece().getColor() &&
                    nodes[r - 1][c].getPiece().getColor() != playerColor) {
                return false;
            }
        }
        if (r!=0 && c!=Config.N_COLUMNS-1 && !nodes[r-1][c+1].isNodeEmpty() && nodes[r - 1][c + 1].getPiece().getColor() == playerColor) {
            if (!nodes[r-1][c].isNodeEmpty() && !nodes[r][c+1].isNodeEmpty() &&
                    nodes[r - 1][c].getPiece().getColor() == nodes[r][c + 1].getPiece().getColor() &&
                    nodes[r - 1][c].getPiece().getColor() != playerColor) {
                return false;
            }
        }
        if (c!=0 && r!=Config.N_ROWS-1 && !nodes[r+1][c-1].isNodeEmpty() && nodes[r + 1][c - 1].getPiece().getColor() == playerColor) {
            if (!nodes[r][c-1].isNodeEmpty() && !nodes[r+1][c].isNodeEmpty() &&
                    nodes[r][c - 1].getPiece().getColor() == nodes[r + 1][c].getPiece().getColor() &&
                    nodes[r][c - 1].getPiece().getColor() != playerColor) {
                return false;
            }
        }
        if (r!=Config.N_ROWS-1 && c!=Config.N_COLUMNS-1 && !nodes[r+1][c+1].isNodeEmpty() &&
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
        return false;
    }
}
