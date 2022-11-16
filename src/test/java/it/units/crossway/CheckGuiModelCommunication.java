package it.units.crossway;

import it.units.crossway.controller.Controller;
import it.units.crossway.controller.GameController;
import it.units.crossway.gui.BoardGui;
import it.units.crossway.gui.BoardGuiSettings;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckGuiModelCommunication {

    private int dim = 1 ;
    private Board board = new Board(1, 1);
    private Controller controller = new GameController(board);
    private BoardGui boardGui = new BoardGui(controller, new BoardGuiSettings(dim, dim, 500, 40));

    @Test
    void Click_perform_place () {
        Coordinates test_point = new Coordinates(0, 0);
        boardGui.handleMouseClicked(test_point);
        assertFalse(controller.getBoard().getNode(test_point).isNodeEmpty());
    }
}
