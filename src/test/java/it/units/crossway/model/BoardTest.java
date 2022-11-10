package it.units.crossway.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    void get_playable_status() {
        assertEquals(true, Board.getNodePlayable(1,1));
    }
}
