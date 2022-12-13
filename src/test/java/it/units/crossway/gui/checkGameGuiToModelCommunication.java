package it.units.crossway.gui;

import it.units.crossway.controller.Controller;
import it.units.crossway.controller.GameController;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;
import it.units.crossway.model.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
public class checkGameGuiToModelCommunication {

    private final static int dim = 5 ;
    private final Board board = new Board(dim, dim);
    private final Controller controller = new GameController(board);
    private final BoardPanel boardPanel = new BoardPanel(controller, new BoardPanelSettings(50, 300, 300, 300/5));

    @BeforeEach
    void setUp() {
        controller.setNameWhitePlayer("test1");
        controller.setNameBlackPlayer("test2");
        boardPanel.drawNamesLabel();
    }

    @Test
    @DisplayName("Coherence in place methods")
    void Click_perform_place () {
        Point test_point = new Point(150, 150);
        test_point = boardPanel.closestNodeToPoint(test_point);
        Coordinates test_coordinates = boardPanel.nodePxToPosition(test_point);
        boardPanel.handleMouseClicked(test_point);
        assertFalse(controller.getBoard().getNode(test_coordinates).isNodeEmpty());
    }

    @Test
    @DisplayName("Ghost display only in correct position")
    void ghostInIllegalPosition() {
        int[] rows = new int[]{1, 2, 2, 1};
        int[] cols = new int[]{1, 1, 2, 2};

        for (int i=0; i<3; i++) {
            boardPanel.handleMouseClicked(boardPanel.nodePositionToPx(new Coordinates(rows[i], cols[i])));
        }

        assertFalse(board.canPlace(new Coordinates(rows[3],cols[3]), new Piece(Color.WHITE) ));

        Point ghostPositionBefore = boardPanel.getGhostPosition();
        boardPanel.handleMouseMoved(boardPanel.nodePositionToPx(new Coordinates(rows[3], cols[3])));

        assertEquals(ghostPositionBefore, boardPanel.getGhostPosition());

        boardPanel.handleMouseMoved(boardPanel.nodePositionToPx(new Coordinates(rows[3]+1, cols[3]+1)));
        assertNotEquals(ghostPositionBefore, boardPanel.getGhostPosition());
    }
}
