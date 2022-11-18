package it.units.crossway.utilities;

import it.units.crossway.model.Coordinates;
import it.units.crossway.model.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class VertexTest {
    private Vertex vertex;
    private Coordinates coordinates;

    @BeforeEach
    public void setup(){
        coordinates = new Coordinates(0,0);
        vertex = new Vertex(coordinates);
    }

    @Test
    void reflexivity(){
        assertTrue(vertex.equals(vertex));
    }

    @Test
    void otherObjectEqualsVertex(){
        assertFalse(vertex.equals(coordinates));
    }

    @Test
    void equalVertices(){
        Vertex vertex2 = new Vertex(coordinates);
        assertTrue(vertex.equals(vertex2));
    }

}
