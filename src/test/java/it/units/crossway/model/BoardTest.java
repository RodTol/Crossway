package it.units.crossway.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void get_initial_playable_state() {
        Board board = new Board();
        assertTrue(board.getNodePlayable(1, 1));
    }

    @Test
    void get_initial_is_empty(){
        Board board = new Board();
        assertTrue(board.isNodeEmpty(1,1));
    }

    @Test
    void coord_check_board_vs_node(){
        Board board = new Board();
        for (int row = 0; row < board.nodes.length; row++) {
            for (int col = 0; col < board.nodes[row].length; col++) {
                assertEquals(row, board.nodes[row][col].getR());
                assertEquals(col, board.nodes[row][col].getC());
            }
        }
    }

    @Test
    void check_placed_piece() {
        Board board = new Board();
        board.placePiece(8, 8, false);
        assertFalse(board.isNodeEmpty(8,8));
    }

}
