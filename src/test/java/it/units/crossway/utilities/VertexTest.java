package it.units.crossway.utilities;

import it.units.crossway.model.Coordinates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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
        assertEquals(vertex, vertex);
    }

    @Test
    @DisplayName("Equal test")
    void otherObjectEqualsVertex(){
        assertNotEquals(vertex, coordinates);
    }

    @Test
    @DisplayName("Equal vertices")
    void equalVertices(){
        Vertex vertex2 = new Vertex(coordinates);
        assertEquals(vertex, vertex2);
    }

}
