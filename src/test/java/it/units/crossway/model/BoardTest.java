package it.units.crossway.model;

import it.units.crossway.utils.Config;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void canPlaceOnEmptyBoard(){
        Board board = new Board();
        for (int row = 0; row < board.getNodes().length; row++) {
            for (int col = 0; col < board.getNodes()[row].length; col++) {
                Coordinates coord = new Coordinates(row, col);
                assertTrue(board.canPlace(coord, new Piece(Color.BLACK)));
            }
        }
    }

    @Test
    void canPlaceIllegalPosition(){
        Board board = new Board();
        Coordinates coord1 = new Coordinates(1,1);
        Coordinates coord2 = new Coordinates(1,2);
        Coordinates coord3 = new Coordinates(2,1);
        Coordinates coord4 = new Coordinates(2,2);

        Piece piece1 = new Piece(Color.BLACK);
        Piece piece2 = new Piece(Color.WHITE);
        Piece piece3 = new Piece(Color.WHITE);

        board.place(coord1, piece1);
        board.place(coord2, piece2);
        board.place(coord3, piece3);

        assertFalse(board.canPlace(coord4,new Piece(Color.BLACK)));
    }

}
