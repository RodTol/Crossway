package it.units.crossway.model;
import it.units.crossway.utilities.Graph;

import java.awt.*;
import java.util.List;


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

    /*Vale la pena farlo ? A sto punto non conviene
    * vedere quanto è grande il grafo (O(19) per costruirlo
    * + O(1) di quanto è lunga la lista) */
    public int NumbOfPieces (Color color) {
        int total = 0;
        for (int r = 0; r < nodes.length; r++) {
            for (int c = 0; c < nodes.length; c++) {
                if (nodes[r][c].getPiece().getColor().equals(color)) {
                    total++;
                }
            }
        }
        return total;
    }

    /*The board can decide if a piece can be placed upon itself
    * but not if is a winner piece because that's a more abstracted
    * concept. So we make that part of the GameController*/
    public boolean canPlace(Coordinates coordinates, Piece piece) {
        int nRows = nodes.length;
        int nColumns = nodes[0].length;

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
        if (r!=0 && c!= nColumns -1 && !nodes[r-1][c+1].isNodeEmpty() && nodes[r - 1][c + 1].getPiece().getColor() == playerColor) {
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
        if (r!=nRows-1 && c!= nColumns -1 && !nodes[r+1][c+1].isNodeEmpty() &&
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

    public boolean hasAtLeastOneinRow(int index, Color color) {
        return false;
    }


    public Graph toGraph(Color color) {
        Graph graph = new Graph();
        for (int r = 0; r < nodes.length; r++) {
            for (int c = 0; c < nodes.length; c++) {
                if (!nodes[r][c].isNodeEmpty() && nodes[r][c].getPiece().getColor().equals(color)) {
                    graph.insert(new Coordinates(r, c));
                }
            }
        }
        return graph;
    }
}
