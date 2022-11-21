package it.units.crossway.controller;

import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;
import it.units.crossway.model.Piece;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

class WinControllerTest {

    WinController winController;
    Board board;
    /*Come faccio a fare il test sui due colori?*/
    Color color;

    @BeforeEach
    @DisplayName("WinController test on 3x3 board")
    void setUp() {
        board = new Board(4,4);
    }

    @Test
    @DisplayName("Enough pieces")
    void enoughPieces()
    {
        color = Color.BLACK;

        int[] rows = new int[]{0, 1, 2, 3};
        int[] cols = new int[]{1, 1, 2, 2};

        for (int i = 0; i< rows.length; i++) {
            board.place(new Coordinates(rows[i],cols[i]), new Piece(color));
        }
        winController = new WinController(board,color);
        Assertions.assertTrue(winController.minNofPieces());
    }

    @Test
    @DisplayName("Black Test")
    void blackTest()
    {
        color = Color.BLACK;
        int[] rows = new int[]{0, 1, 2, 3};
        int[] cols = new int[]{1, 1, 2, 2};
        for (int i = 0; i< rows.length; i++) {
            board.place(new Coordinates(rows[i],cols[i]), new Piece(color));
        }
        winController = new WinController(board,color);
        Assertions.assertTrue(winController.blackCheck());
    }

    @Test
    @DisplayName("White Test")
    void whiteTest()
    {
        color = Color.WHITE;
        int[] rows = new int[]{1, 1, 2, 3};
        int[] cols = new int[]{0, 1, 2, 3};
        for (int i = 0; i< rows.length; i++) {
            board.place(new Coordinates(rows[i],cols[i]), new Piece(color));
        }
        winController = new WinController(board,color);
        Assertions.assertTrue(winController.whiteCheck());
    }


    @ParameterizedTest
    @DisplayName("Win check")
    @ValueSource(booleans = {true,false})
    void winTest(boolean input) {

        if (input) {
            color = BLACK;
        } else  {
            color = WHITE;
        }

        int[] rows = new int[]{0, 0, 1, 2, 3, 3};
        int[] cols = new int[]{1, 3, 1, 2, 0, 2};


        for (int i = 0; i< rows.length; i++) {
            board.place(new Coordinates(rows[i],cols[i]), new Piece(color));
        }
        winController = new WinController(board,color);

        if (input) {
            Assertions.assertTrue(winController.check());
        } else  {
            Assertions.assertFalse(winController.check());
        }

    }


}