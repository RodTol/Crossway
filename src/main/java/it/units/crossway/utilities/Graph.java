package it.units.crossway.utilities;

import it.units.crossway.model.Coordinates;
import org.apache.commons.lang3.builder.EqualsBuilder;

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

    public void addVertex(Coordinates coordinates){
        Vertex vertex = new Vertex(coordinates);
        ArrayList<Vertex> adjVertices = new ArrayList<Vertex>();
        adjList.putIfAbsent(vertex,adjVertices);
    }

    public void addEdge(Coordinates coordinates1, Coordinates coordinates2) {
        Vertex vertex1 = new Vertex(coordinates1);
        Vertex vertex2 = new Vertex(coordinates2);
        if (!getAdjList().containsKey(vertex1)) {
            //exception?
        } else {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
        }
    }

    public void insert(Coordinates coordinates) {
        this.addVertex(coordinates);
        for (Vertex vertex: adjList.keySet()) {
            if (vertex.getValue().isNeighbour(coordinates)) {
                this.addEdge(vertex.getValue(), coordinates);
            }
        }
    }


    public Set<Coordinates> DepthFirstSearch(Coordinates startCoordinates){
        Set<Coordinates> visitedCoordinates = new LinkedHashSet<>();
        Stack<Coordinates> coordinatesStack = new Stack<>();

        coordinatesStack.push(startCoordinates);

        while (!coordinatesStack.isEmpty()){
            Coordinates currentCoordinates = coordinatesStack.pop();
            if (!visitedCoordinates.contains(currentCoordinates)){
                visitedCoordinates.add(currentCoordinates);
                for (Vertex v : getAdjList().get(new Vertex(currentCoordinates))) {
                    coordinatesStack.push(v.getValue());
                }
            }
        }
        return visitedCoordinates;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Graph)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Graph o = (Graph) obj;
        return new EqualsBuilder()
                .append(adjList, o.adjList)
                .isEquals();
    }

}
