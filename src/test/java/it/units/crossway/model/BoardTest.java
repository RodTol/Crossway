package it.units.crossway.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    @Test
    void get_initial_playable_state() {
        Board board = new Board(19, 19);
        assertTrue(board.isNodePlayable(1, 1));
    }

//    @Test
//    void coord_check_board_vs_node(){
//        Board board = new Board(19, 19);
//        for (int row = 0; row < board.nodes.length; row++) {
//            for (int col = 0; col < board.nodes[row].length; col++) {
//                assertEquals(row, board.nodes[row][col].getR());
//                assertEquals(col, board.nodes[row][col].getC());
//            }
//        }
//    }
}
