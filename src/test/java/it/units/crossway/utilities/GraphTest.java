package it.units.crossway.utilities;

import it.units.crossway.model.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    private Vertex vertex;
    private Piece piece;
    private Graph graph;

    @BeforeEach
    public void setup(){
        piece = new Piece(Color.BLACK);
        vertex = new Vertex(piece);
        graph = new Graph();
    }

    @Test
    void emptyGraph(){
        assertFalse(graph.getAdjList().containsKey(vertex));
    }

    @Test
    void addVertexToEmptyGraph(){
        graph.addVertex(piece);
        assertTrue(graph.getAdjList().containsKey(vertex));
    }

    @Test
    void depthFirstSearch(){
        Piece piece2 = new Piece(Color.BLACK);
        Piece piece3 = new Piece(Color.BLACK);
        Piece piece4 = new Piece(Color.BLACK);

        graph.addVertex(piece);
        graph.addVertex(piece2);
        graph.addVertex(piece3);
        graph.addVertex(piece4);

        graph.addEdge(piece,piece2);
        graph.addEdge(piece2,piece3);
        graph.addEdge(piece2,piece4);

        Set<Piece> outputSet = new LinkedHashSet<>();
        Set<Piece> expectedSet = new LinkedHashSet<>();
        expectedSet.add(piece);
        expectedSet.add(piece2);
        expectedSet.add(piece3);
        expectedSet.add(piece4);
        outputSet = graph.DepthFirstSearch(piece);
        assertEquals(expectedSet,outputSet);
    }
}
