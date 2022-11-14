package it.units.crossway.model;

import it.units.crossway.exceptions.NullPieceException;
import it.units.crossway.utils.Config;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NodeTest {
    @Test
    void initialNodesAreEmpty(){
        Board board = new Board(Config.N_ROWS,Config.N_COLUMNS);
        for (int row = 0; row < board.getNodes().length; row++) {
            for (int col = 0; col < board.getNodes()[row].length; col++) {
                assertTrue(board.getNodes()[row][col].isNodeEmpty());
            }
        }
    }
}
