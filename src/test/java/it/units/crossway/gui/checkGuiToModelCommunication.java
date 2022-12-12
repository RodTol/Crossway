package it.units.crossway.gui;

import it.units.crossway.controller.Controller;
import it.units.crossway.controller.GameController;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SuppressWarnings("NewClassNamingConvention")
public class checkGuiToModelCommunication {

    private final int dim = 19 ;
    private final Board board = new Board(dim, dim);
    private final Controller controller = new GameController(board);
    private final BoardPanel boardPanel = new BoardPanel(controller, new BoardPanelSettings(300, 300, 300, 300));

    @BeforeEach
    void setUp() {
        controller.setNameWhitePlayer("test1");
        controller.setNameBlackPlayer("test2");
        boardPanel.drawNames();
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

}
