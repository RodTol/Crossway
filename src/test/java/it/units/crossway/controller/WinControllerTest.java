package it.units.crossway.controller;

import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;
import it.units.crossway.model.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WinControllerTest {

    WinController winController;
    Board board;
    Color color;

    @BeforeEach
    @DisplayName("WinController test on 3x3 board")
    void setUp() {
        board = new Board(3,3);

        int[] rows = new int[]{0, 1, 2};
        int[] cols = new int[]{1, 1, 2};

        for (int i = 0; i< rows.length; i++) {
            board.place(new Coordinates(rows[i],cols[i]), new Piece(Color.BLACK));
        }

        color = Color.BLACK;
    }

    @Test
    @DisplayName("Win check")
    void winTest() {
        winController = new WinController(board,color);
        assertTrue(winController.check());
    }


}