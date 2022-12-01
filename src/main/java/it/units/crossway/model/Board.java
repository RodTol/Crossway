package it.units.crossway.model;
import it.units.crossway.utilities.Graph;

import java.awt.*;
import java.util.ArrayList;

public class Board {

    /*Matrix of Nodes*/
    private final Node[][] nodes;

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


    public int NumbOfPieces (Color color) {
        int total = 0;
        for (Node[] row : nodes) {
            for (int c = 0; c < nodes.length; c++) {
                if (row[c].getPiece() != null && row[c].getPiece().getColor().equals(color)) {
                    total++;
                }
            }
        }
        return total;
    }

    public ArrayList<Coordinates> piecesInRow(int index, Color color) {
        ArrayList<Coordinates> pieces = new ArrayList<>();
        for (int i = 0; i < nodes[index].length; i++) {
            if (nodes[index][i].getPiece() != null &&
                    nodes[index][i].getPiece().getColor().equals(color)) {
                pieces.add(new Coordinates(index, i));
            }
        }
        return pieces;
    }

    public ArrayList<Coordinates> piecesInColumn(int index, Color color) {
        Node[] column = new Node[nodes.length];
        for (int i = 0; i < nodes[0].length; i++) {
            column[i] = nodes[i][index];
        }

        ArrayList<Coordinates> pieces = new ArrayList<>();
        for (int i = 0; i < column.length; i++) {
            if (column[i].getPiece() != null &&
                    column[i].getPiece().getColor().equals(color)) {
                pieces.add(new Coordinates(i, index));
            }
        }
        return pieces;
    }

    public boolean hasAtLeastOneInRow(int index, Color color) {
        for (Node node : nodes[index] ) {
            if (node.getPiece() != null && node.getPiece().getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAtLeastOneInColumn(int index, Color color) {
        Node[] column = new Node[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            column[i] = nodes[i][index];
        }

        for (Node node: column) {
            if (node.getPiece() != null && node.getPiece().getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }

    /*The board can decide if a piece can be placed upon itself
    * but not if is a winner piece because that's a more abstracted
    * concept. So we make that part of the GameController*/
    public boolean canPlace(Coordinates coordinates, Piece piece) {
        int nRows = nodes.length;
        int nColumns = nodes[0].length;

        //int r = coordinates.getRow();
        //int c = coordinates.getColumn();
        Color playerColor = piece.getColor();



        if (!getNode(coordinates).isNodeEmpty()) {
            return false;
        }

        if (coordinates.getRow()!=0 && coordinates.getColumn()!=0 &&
                !getNode(coordinates.getNorthWestNeighbour()).isNodeEmpty() &&
                getNode(coordinates.getNorthWestNeighbour()).getPiece().getColor() == playerColor) {
            if (!getNode(coordinates.getNorthNeighbour()).isNodeEmpty() && !getNode(coordinates.getWestNeighbour()).isNodeEmpty() &&
                    getNode(coordinates.getNorthNeighbour()).getPiece().getColor() == getNode(coordinates.getWestNeighbour()).getPiece().getColor() &&
                    getNode(coordinates.getNorthNeighbour()).getPiece().getColor() != playerColor) {
                return false;
            }
        }
        if (coordinates.getRow()!=0 && coordinates.getColumn()!= nColumns - 1 &&
                !getNode(coordinates.getNorthEastNeighbour()).isNodeEmpty() && getNode(coordinates.getNorthEastNeighbour()).getPiece().getColor() == playerColor) {
            if (!getNode(coordinates.getNorthNeighbour()).isNodeEmpty() && !getNode(coordinates.getEastNeighbour()).isNodeEmpty() &&
                    getNode(coordinates.getNorthNeighbour()).getPiece().getColor() == getNode(coordinates.getEastNeighbour()).getPiece().getColor() &&
                    getNode(coordinates.getNorthNeighbour()).getPiece().getColor() != playerColor) {
                return false;
            }
        }
        if (coordinates.getColumn()!=0 && coordinates.getRow()!=nRows-1 &&
                !getNode(coordinates.getSouthWestNeighbour()).isNodeEmpty() && getNode(coordinates.getSouthWestNeighbour()).getPiece().getColor() == playerColor) {
            if (!getNode(coordinates.getWestNeighbour()).isNodeEmpty() && !getNode(coordinates.getSouthNeighbour()).isNodeEmpty() &&
                    getNode(coordinates.getWestNeighbour()).getPiece().getColor() == getNode(coordinates.getSouthNeighbour()).getPiece().getColor() &&
                    getNode(coordinates.getWestNeighbour()).getPiece().getColor() != playerColor) {
                return false;
            }
        }
        if (coordinates.getRow()!=nRows-1 && coordinates.getColumn()!= nColumns -1 &&
                !getNode(coordinates.getSouthEastNeighbour()).isNodeEmpty() && getNode(coordinates.getSouthEastNeighbour()).getPiece().getColor() == playerColor) {
            if (!getNode(coordinates.getEastNeighbour()).isNodeEmpty() && !getNode(coordinates.getSouthNeighbour()).isNodeEmpty() &&
                    getNode(coordinates.getEastNeighbour()).getPiece().getColor() == getNode(coordinates.getSouthNeighbour()).getPiece().getColor() &&
                    getNode(coordinates.getEastNeighbour()).getPiece().getColor() != playerColor) {
                return false;
            }
        }
        return true;
    }

    public void place(Coordinates c, Piece piece) {
        nodes[c.getRow()][c.getColumn()] = new Node();
        nodes[c.getRow()][c.getColumn()].setPiece(piece);
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

    public void reset() {
        for (int r = 0; r < nodes.length; r++) {
            for (int c = 0; c < nodes[0].length; c++) {
                nodes[r][c].setPiece(null);
            }
        }
    }
}
