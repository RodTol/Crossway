package it.units.crossway.utilities;

import it.units.crossway.model.Coordinates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class VertexTest {
    private Vertex vertex;
    private Coordinates coordinates;

    @BeforeEach
    @DisplayName("Tests on vertex class")
    public void setup(){
        coordinates = new Coordinates(0,0);
        vertex = new Vertex(coordinates);
    }

    @Test
    @DisplayName("Reflexivity")
    void reflexivity(){
        assertTrue(vertex.equals(vertex));
    }

    @Test
    @DisplayName("Equal test")
    void otherObjectEqualsVertex(){
        assertFalse(vertex.equals(coordinates));
    }

    @Test
    @DisplayName("Equal vertices")
    void equalVertices(){
        Vertex vertex2 = new Vertex(coordinates);
        assertTrue(vertex.equals(vertex2));
    }

}
