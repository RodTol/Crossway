package it.units.crossway;

import it.units.crossway.controller.Controller;
import it.units.crossway.controller.GameController;
import it.units.crossway.gui.BoardPanel;
import it.units.crossway.gui.BoardPanelSettings;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckGuiModelCommunication {

    private int dim = 2 ;
    private Board board = new Board(dim, dim);
    private Controller controller = new GameController(board);
    private BoardPanel boardPanel = new BoardPanel(controller, new BoardPanelSettings(dim, dim, 500, 40));

    @Test
    @DisplayName("Coherence in place methods")
    void Click_perform_place () {
        Coordinates test_point = new Coordinates(0, 0);
        boardPanel.handleMouseClicked(test_point);
        assertFalse(controller.getBoard().getNode(test_point).isNodeEmpty());
    }
}
