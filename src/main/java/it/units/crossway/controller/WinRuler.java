package it.units.crossway.controller;

import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;
import it.units.crossway.utilities.Graph;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class WinRuler {
    private final Board board;
    private final Color color;

    WinRuler(Board board, Color color) {
        this.board = board;
        this.color = color;
    }

    boolean winCheck() {
        if (!minNofPieces()) {
            return false;
        }

        if (color.equals(Color.BLACK)) {
            for (int i = 0; i < board.getNodes().length; i++) {
                if (!board.hasAtLeastOneOfColorInRow(i, color)) {
                    return false;
                }
            }
        } else if (color.equals(Color.WHITE)) {
            for (int i = 0; i < board.getNodes().length; i++) {
                if (!board.hasAtLeastOneOfColorInColumn(i, color)) {
                    return false;
                }
            }
        }

        Graph graph = board.toGraph(color);
        ArrayList<Coordinates> startingVertices;

        if (color.equals(Color.BLACK)) {
            startingVertices = board.piecesInRowWithColor(0,color);
        } else  {
            startingVertices = board.piecesInColumnWithColor(0, color);
        }

        for (Coordinates coordinates : startingVertices) {
            Set<Coordinates> depthFirstTree =  graph.depthFirstSearch(coordinates);
            List<Coordinates> filteredTree;

            if (color.equals(Color.BLACK)) {
                filteredTree = depthFirstTree
                        .stream()
                        .filter(v -> v.getRow() == board.getNodes().length - 1)
                        .collect(Collectors.toList());
            } else  {
                filteredTree = depthFirstTree
                        .stream()
                        .filter(v -> v.getColumn() == board.getNodes().length - 1)
                        .collect(Collectors.toList());
            }

            if ( filteredTree.size() >= 1) {
                return true;
            }
        }
        return false;
    }

    boolean minNofPieces() {
        return board.numOfPlacedPiecesWithColor(color) >= board.getNodes().length;
    }

}
