package it.units.crossway.model;

import it.units.crossway.utilities.Vertex;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    Coordinates a;

    @BeforeEach
    @DisplayName("Coordinates test")
    void setup() {
        a = new Coordinates(1,2);
    }

    @Test
    @DisplayName("Reflexivity")
    void reflexivity(){
        assertTrue(a.equals(a));
    }

    @Test
    @DisplayName("Equal test")
    void otherObjectEqualsVertex(){
        Piece piece = new Piece(Color.BLACK);
        assertFalse(a.equals(piece));
    }

    @Test
    void testEqual() {
        assertTrue(a.equals(new Coordinates(1,2)));
    }


    @ParameterizedTest
    @CsvSource({"0,true","1,false","5,false"})
    void isNeighbour(int number, String expected) {
        assertEquals(expected, String.valueOf(a.isNeighbour(new Coordinates(number,2))));
    }
}