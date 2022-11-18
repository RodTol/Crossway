package it.units.crossway.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    @Test
    @DisplayName("Initial node is empty")
    void initialNodesAreEmpty(){
        Board board = new Board(4, 5);
        //va fatto un ciclo sulle coordinate?
        for (int row = 0; row < board.getNodes().length; row++) {
            for (int col = 0; col < board.getNodes()[row].length; col++) {
                assertTrue(board.getNodes()[row][col].isNodeEmpty());
            }
        }
    }

    @Test
    @DisplayName("Place is working")
    void notEmptyNode(){
        Board board = new Board(4, 5);
        Coordinates coord = new Coordinates(1,2);
        Piece piece = new Piece(Color.BLACK);
        board.place(coord, piece);
        assertFalse(board.getNodes()[coord.getRow()][coord.getColumn()].isNodeEmpty());
    }
}
