package it.units.crossway;

import it.units.crossway.controller.Controller;
import it.units.crossway.controller.GameController;
import it.units.crossway.gui.BoardPanel;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;

import it.units.crossway.model.Piece;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;

public class fictionalGame {

    private final int dim = 4;
    private static Board board;

    @BeforeEach
    @DisplayName("Fictional game initialisation on 4x4 board")
    public void set_up() {

        board = new Board(dim, dim);
        Controller controller = new GameController(board);
        BoardPanel boardPanel = Mockito.mock(BoardPanel.class);
    }

    @Test
    @DisplayName("Tests initial conditions")
    public void initial_conditions() {
        for (int r = 0; r < dim; r++) {
            for (int c = 0; c < dim; c++) {
                Assertions.assertTrue(board.canPlace(new Coordinates(r, c), new Piece(Color.BLACK)));
                Assertions.assertNull(board.getNode(new Coordinates(r,c)).getPiece());
            }
        }
    }
}
