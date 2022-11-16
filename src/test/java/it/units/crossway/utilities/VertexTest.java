package it.units.crossway.utilities;

import it.units.crossway.model.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class VertexTest {
    private Vertex vertex;
    private Piece piece;

    @BeforeEach
    public void setup(){
        piece = new Piece(Color.BLACK);
        vertex = new Vertex(piece);
    }

    @Test
    void reflexivity(){
        assertTrue(vertex==vertex);
    }

    @Test
    void otherObjectEqualsVertex(){
        assertFalse(vertex.equals(piece));
    }
}
