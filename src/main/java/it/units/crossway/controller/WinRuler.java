package it.units.crossway.controller;

import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;
import it.units.crossway.utilities.Graph;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinRuler {
    private final Board board;
    private final Color color;

    public WinRuler(Board board, Color color) {
        this.board = board;
        this.color = color;
    }

    public boolean check() {
        if (!minNofPieces()) {
            return false;
        }

        if (color.equals(Color.BLACK)) {
            return blackCheck();
        } else {
            return whiteCheck();
        }
    }

    boolean minNofPieces() {
        return board.NumbOfPieces(color) >= board.getNodes().length;
    }

    @SuppressWarnings("SimplifyStreamApiCallChains")
    boolean blackCheck() {
        for (int i = 0; i < board.getNodes().length; i++) {
            if (!board.hasAtLeastOneInRow(i, color)) {
                return false;
            }
        }

        Graph graph = board.toGraph(color);
        ArrayList<Coordinates> startingVertices;
        startingVertices = board.piecesInRow(0,color);

        for (Coordinates coordinates : startingVertices) {
            Set<Coordinates> depthFirstTree =  graph.DepthFirstSearch(coordinates);
            List<Coordinates> filteredTree = depthFirstTree
                    .stream()
                    .filter(v -> v.getRow() == board.getNodes().length - 1)
                    .collect(Collectors.toList());

            if ( filteredTree.size() >= 1) {
                return true;
            }
        }

        return false;
    }

    @SuppressWarnings("SimplifyStreamApiCallChains")
    boolean whiteCheck() {
        for (int i = 0; i < board.getNodes().length; i++) {
            if (!board.hasAtLeastOneInColumn(i, color)) {
                return false;
            }
        }

        Graph graph = board.toGraph(color);
        ArrayList<Coordinates> startingVertices;
        startingVertices = board.piecesInColumn(0,color);

        for (Coordinates coordinates : startingVertices) {
            Set<Coordinates> depthFirstTree =  graph.DepthFirstSearch(coordinates);
            List<Coordinates> filteredTree = depthFirstTree
                    .stream()
                    .filter(v -> v.getColumn() == board.getNodes().length - 1)
                    .collect(Collectors.toList());

            if ( filteredTree.size() >= 1) {
                return true;
            }
        }

        return false;
    }


}