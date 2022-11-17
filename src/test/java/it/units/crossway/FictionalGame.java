package it.units.crossway;

import it.units.crossway.controller.Controller;
import it.units.crossway.controller.GameController;
import it.units.crossway.gui.BoardGui;
import it.units.crossway.model.Board;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FictionalGame {

    private static Board board;
    private Controller controller;
    private BoardGui boardGui;

    @Before
    @DisplayName("Fictional game initialisation on 4x4 board")
    public void set_up() {
        int dim = 4;
        board = new Board(dim, dim);
        controller = new GameController(board);
        boardGui = Mockito.mock(BoardGui.class);
    }

    @Test
    @DisplayName("Tests initial conditions")
    void initial_conditions() {

    }
}
