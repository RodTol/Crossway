package it.units.crossway.utilities;

import it.units.crossway.model.Coordinates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    private Vertex vertex;
    private Coordinates coordinates;
    private Graph graph;

    @BeforeEach
    @DisplayName("Tests on Graph class")
    public void setup(){
        coordinates = new Coordinates(0,0);
        vertex = new Vertex(coordinates);
        graph = new Graph();
    }

    @Test
    @DisplayName("Empty graph at initialisation")
    void emptyGraph(){
        assertFalse(graph.getAdjList().containsKey(vertex));
    }

    @Test
    @DisplayName("Add vertex")
    void addVertexToEmptyGraph(){
        graph.addVertex(coordinates);
        assertTrue(graph.getAdjList().containsKey(vertex));
    }

    @Test
    @DisplayName("Insertion in empty Graph")
    void insertVertexEmptyGraph() {
        graph.insert(coordinates);
        assertTrue(graph.getAdjList().get(new Vertex(coordinates)).isEmpty());
    }

    @Test
    @DisplayName("Insertion test")
    void insertGraph() {
        graph.insert(coordinates);
        graph.insert(new Coordinates(2,4));
        assertTrue(graph.getAdjList().get(new Vertex(coordinates)).isEmpty());
        graph.insert(new Coordinates(1,1));
        assertEquals(new Vertex(new Coordinates(1,1)), graph.getAdjList().get(new Vertex(coordinates)).get(0));
    }

    @Test
    @DisplayName("DFS")
    void depthFirstSearch(){
        Coordinates coordinates2 = new Coordinates(0,1);
        Coordinates coordinates3 = new Coordinates(0,2);
        Coordinates coordinates4 = new Coordinates(1,1);

        graph.addVertex(coordinates);
        graph.addVertex(coordinates2);
        graph.addVertex(coordinates3);
        graph.addVertex(coordinates4);

        graph.addEdge(coordinates,coordinates2);
        graph.addEdge(coordinates2,coordinates3);
        graph.addEdge(coordinates2,coordinates4);

        Set<Coordinates> outputSet = new LinkedHashSet<>();
        Set<Coordinates> expectedSet = new LinkedHashSet<>();
        expectedSet.add(coordinates);
        expectedSet.add(coordinates2);
        expectedSet.add(coordinates3);
        expectedSet.add(coordinates4);
        outputSet = graph.DepthFirstSearch(coordinates);
        assertEquals(expectedSet,outputSet);
    }
}
