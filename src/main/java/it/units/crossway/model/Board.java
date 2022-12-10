package it.units.crossway.model;
import it.units.crossway.utilities.Graph;

import java.awt.*;
import java.util.ArrayList;

public class Board {
    private final Node[][] nodes;

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

    public int numOfPlacedPiecesWithColor(Color color) {
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

    public ArrayList<Coordinates> piecesInRowWithColor(int index, Color color) {
        ArrayList<Coordinates> pieces = new ArrayList<>();
        for (int i = 0; i < nodes[index].length; i++) {
            if (nodes[index][i].getPiece() != null &&
                    nodes[index][i].getPiece().getColor().equals(color)) {
                pieces.add(new Coordinates(index, i));
            }
        }
        return pieces;
    }

    public ArrayList<Coordinates> piecesInColumnWithColor(int index, Color color) {
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

    public boolean hasAtLeastOneOfColorInRow(int index, Color color) {
        for (Node node : nodes[index] ) {
            if (node.getPiece() != null && node.getPiece().getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAtLeastOneOfColorInColumn(int index, Color color) {
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

    public boolean canPlace(Coordinates coordinates, Piece piece) {
        Color playerColor = piece.getColor();
        if (!getNode(coordinates).isNodeEmpty()) {
            return false;
        }

        for (Direction dir : Direction.values()) {
            if ( sameColorPieceOnDiagonal(coordinates, playerColor, dir)) {
                if ( differentColorPiecesOnOrthogonal(coordinates, playerColor, dir) ) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isOnDirectionSides(Coordinates coordinates, Direction direction) throws RuntimeException {
        switch (direction) {
            case NORTH_WEST: {
                return coordinates.getRow()==0 || coordinates.getColumn()==0;
            }
            case NORTH_EAST: {
                return coordinates.getRow()==0 || coordinates.getColumn()==nodes[0].length-1;
            }
            case SOUTH_WEST: {
                return coordinates.getRow()==nodes[0].length-1 || coordinates.getColumn()==0;
            }
            case SOUTH_EAST: {
                return  coordinates.getRow()==nodes[0].length-1 || coordinates.getColumn()==nodes[0].length-1;
            }
        }
        throw new RuntimeException();
    }

    private boolean sameColorPieceOnDiagonal(Coordinates coordinates, Color playerColor, Direction dir) {
        return  !isOnDirectionSides(coordinates, dir) &&
                !getNode(coordinates.getDiagonalNeighbour(dir)).isNodeEmpty() &&
                getNode(coordinates.getDiagonalNeighbour(dir)).getPiece().getColor() == playerColor;
    }

    private boolean differentColorPiecesOnOrthogonal(Coordinates coordinates, Color playerColor, Direction dir) {
        return  !getNode(coordinates.getVerticalNeighbour(dir)).isNodeEmpty() &&
                !getNode(coordinates.getHorizontalNeighbour(dir)).isNodeEmpty() &&
                getNode(coordinates.getHorizontalNeighbour(dir)).getPiece().getColor() != playerColor &&
                getNode(coordinates.getVerticalNeighbour(dir)).getPiece().getColor() != playerColor;
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

    public void emptyBoard() {
        for (Node[] row : nodes) {
            for (Node node: row) {
                node.setPiece(null);
            }
        }
    }
}
