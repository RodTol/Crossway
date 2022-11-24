package it.units.crossway.gui;
import it.units.crossway.controller.GameController;
import it.units.crossway.model.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class StartingPanelTest {

    Board board;
    GameController controller;
    StartingPanel startingPanel;
    JFrame frame;

    @BeforeEach
    void setUp() {
        board = new Board( 4,4);
        controller = new GameController(board);
        startingPanel = new StartingPanel(controller);
        frame = new JFrame();
        frame.getContentPane().add(startingPanel, BorderLayout.CENTER);
    }

    @Test
    @DisplayName("Name Inputs")
    void areNameSaved() {
        /*Need to add test text to JText in order to procede*/
        startingPanel.handleLetSPlay();
        assertEquals("USER_1", controller.getWhiteName());
        assertEquals("USER_2", controller.getBlackName());
    }
}