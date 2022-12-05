package it.units.crossway.controller;

import it.units.crossway.model.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(player, player);
    }

    @Test
    @DisplayName("Equal test player")
    void otherObjectEqualsPlayer(){
        assertNotEquals(player, board);
    }

    @Test
    @DisplayName("Equal players")
    void equalPlayers(){
        Player player2 = new Player(2, Color.BLACK);
        assertEquals(player, player2);
    }
}
