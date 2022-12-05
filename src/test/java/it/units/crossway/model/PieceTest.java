package it.units.crossway.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    Piece piece;

    @BeforeEach
    @DisplayName("Coordinates test")
    void setup() {
        piece = new Piece(Color.BLACK);
    }


    @Test
    @DisplayName("Reflexivity")
    void reflexivity(){
        assertEquals(piece, piece);
    }

    @Test
    @DisplayName("Equal test")
    void otherObjectEqualsVertex(){
        assertNotEquals(piece, new Coordinates(1, 1));
    }

    @Test
    @DisplayName("Equal vertices")
    void equalVertices(){
        assertEquals(piece, new Piece(Color.BLACK));
    }
}
