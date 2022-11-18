package it.units.crossway.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;
    @BeforeEach
    public void setup() {
        board = new Board(5,5);
    }
    @Test
    @DisplayName("Empty Board")
    void canPlaceOnEmptyBoard(){
        for (int row = 0; row < board.getNodes().length; row++) {
            for (int col = 0; col < board.getNodes()[row].length; col++) {
                Coordinates coord = new Coordinates(row, col);
                assertTrue(board.canPlace(coord, new Piece(Color.BLACK)));
            }
        }
    }

    @Test
    @DisplayName("Illegal position")
    void canPlaceIllegalPosition(){
        Coordinates cord1 = new Coordinates(1,1);
        Coordinates cord2 = new Coordinates(1,2);
        Coordinates cord3 = new Coordinates(2,1);
        Coordinates cord4 = new Coordinates(2,2);

        Piece piece1 = new Piece(Color.BLACK);
        Piece piece2 = new Piece(Color.WHITE);
        Piece piece3 = new Piece(Color.WHITE);

        board.place(cord1, piece1);
        board.place(cord2, piece2);
        board.place(cord3, piece3);

        assertFalse(board.canPlace(cord4,new Piece(Color.BLACK)));
    }

}
