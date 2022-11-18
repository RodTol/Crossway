package it.units.crossway.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    Coordinates a;

    @BeforeEach
    @DisplayName("Coordinates test")
    void setup() {
        a = new Coordinates(1,2);
    }

    @ParameterizedTest
    @CsvSource({"0,true","1,true","5,false"})
    void isNeighbour(int number, String expected) {
        assertEquals(expected, String.valueOf(a.isNeighbour(new Coordinates(number,2))));
    }
}