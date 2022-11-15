package it.units.crossway.model;

import it.units.crossway.exceptions.NullPieceException;
import it.units.crossway.utils.Config;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    @Test
    void initialNodesAreEmpty(){
        Board board = new Board();
        //va fatto un ciclo sulle coordinate?
        for (int row = 0; row < board.getNodes().length; row++) {
            for (int col = 0; col < board.getNodes()[row].length; col++) {
                assertTrue(board.getNodes()[row][col].isNodeEmpty());
            }
        }
    }

    @Test
    void notEmptyNode(){
        Board board = new Board();
        Coordinates coord = new Coordinates(1,2);
        Piece piece = new Piece(Color.BLACK);
        board.place(coord, piece);
        assertFalse(board.getNodes()[coord.getRow()][coord.getColumn()].isNodeEmpty());
    }
}
