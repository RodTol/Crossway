package it.units.crossway.controller;

import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;
import it.units.crossway.utilities.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.function.BiPredicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Equality {

    Player player;
    Board board;

    @BeforeEach
    @DisplayName("Tests on vertex class")
    public void setup(){
        player = new Player(1, Color.BLACK);
        board = new Board(1,1);
    }

    @Test
    @DisplayName("Reflexivity player")
    void reflexivity(){
        assertTrue(player.equals(player));
    }

    @Test
    @DisplayName("Equal test player")
    void otherObjectEqualsPlayer(){
        assertFalse(player.equals(board));
    }

    @Test
    @DisplayName("Equal players")
    void equalPlayers(){
        Player player2 = new Player(2, Color.BLACK);
        assertTrue(player.equals(player2));
    }
}
