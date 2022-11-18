package it.units.crossway.utilities;

import it.units.crossway.model.Piece;

import java.util.*;

public class Graph {
    //We define a graph through an adjacency list
    private Map<Vertex, List<Vertex>> adjList;

    public Graph(){
        adjList = new HashMap<>();
    }

    public Map<Vertex, List<Vertex>> getAdjList() {
        return adjList;
    }

    void addVertex(Piece piece){
        Vertex vertex = new Vertex(piece);
        ArrayList<Vertex> adjVertices = new ArrayList<Vertex>();
        adjList.putIfAbsent(vertex,adjVertices);
    }

    void addEdge(Piece piece1, Piece piece2) {
        Vertex vertex1 = new Vertex(piece1);
        Vertex vertex2 = new Vertex(piece2);
        if (!getAdjList().containsKey(vertex1)) {
            //exception?
        } else {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
        }
    }

    Set<Piece> DepthFirstSearch(Piece startPiece){
        Set<Piece> visitedPieces = new LinkedHashSet<Piece>();
        Stack<Piece> pieceStack = new Stack<Piece>();

        pieceStack.push(startPiece);

        while (!pieceStack.isEmpty()){
            Piece currentPiece = pieceStack.pop();
            if (!visitedPieces.contains(currentPiece)){
                visitedPieces.add(currentPiece);
                for (Vertex v : getAdjList().get(new Vertex(currentPiece))) {
                    pieceStack.push(v.value);
                }
            }
        }
        return visitedPieces;
    }


}
