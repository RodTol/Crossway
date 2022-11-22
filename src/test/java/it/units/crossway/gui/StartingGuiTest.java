package it.units.crossway.gui;
import it.units.crossway.controller.GameController;
import it.units.crossway.model.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartingGuiTest {

    Board board;
    GameController controller;
    StartingGui startingGui;

    @BeforeEach
    void setUp() {
        board = new Board( 4,4);
        controller = new GameController(board);
        startingGui = new StartingGui(controller);
    }

    @Test
    @DisplayName("Name Inputs")
    void areNameSaved() {
        startingGui.handleLetSPlay("USER_1", "USER_2");
        assertEquals("USER_1", controller.getWhiteName());
        assertEquals("USER_2", controller.getBlackName());
    }
}