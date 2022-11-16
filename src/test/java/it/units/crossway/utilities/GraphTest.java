package it.units.crossway.utilities;

import it.units.crossway.model.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void addVertexToEmptyGraph(){
        graph.addVertex(piece);
        assertTrue(graph.getAdjList().containsKey(vertex));
    }
}
