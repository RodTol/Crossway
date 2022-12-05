package it.units.crossway.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(piece.equals(piece));
    }

    @Test
    @DisplayName("Equal test")
    void otherObjectEqualsVertex(){
        assertFalse(piece.equals(new Coordinates(1,1)));
    }

    @Test
    @DisplayName("Equal vertices")
    void equalVertices(){
        assertTrue(piece.equals(new Piece(Color.BLACK)));
    }
}
