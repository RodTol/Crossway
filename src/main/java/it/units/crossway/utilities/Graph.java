package it.units.crossway.utilities;

import it.units.crossway.model.Piece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    void addEdge(Piece piece1, Piece piece2){
        Vertex vertex1 = new Vertex(piece1);
        Vertex vertex2 = new Vertex(piece2);
        adjList.get(vertex1).add(vertex2);
        adjList.get(vertex2).add(vertex1);
    }

}
