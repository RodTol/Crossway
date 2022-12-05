package it.units.crossway.gui;

import it.units.crossway.controller.Controller;
import it.units.crossway.controller.GameController;
import it.units.crossway.gui.BoardPanel;
import it.units.crossway.model.Board;
import org.mockito.Mockito;

public class CheckGuiModelCommunication {

    private int dim = 2 ;
    private Board board = new Board(dim, dim);
    private Controller controller = new GameController(board);
    private BoardPanel boardPanel = Mockito.mock(BoardPanel.class);


    /*
    @Test
    @DisplayName("Coherence in place methods")
    void Click_perform_place () {
        Point test_point = new Point(40, 10);
        test_point = boardPanel.closestNodeToPx(test_point);
        Coordinates coordinates = boardPanel.nodePxToPosition(test_point);
        boardPanel.handleMouseClicked(test_point);
        assertFalse(controller.getBoard().getNode(coordinates).isNodeEmpty());
    }


     */
}
