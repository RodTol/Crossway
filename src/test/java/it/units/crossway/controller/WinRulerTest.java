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

class WinRulerTest {

    WinRuler winRuler;
    Board board;
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
        winRuler = new WinRuler(board,color);
        Assertions.assertTrue(winRuler.minNofPieces());
    }

    @Test
    @DisplayName("Black win check Test")
    void blackTest()
    {
        color = Color.BLACK;
        int[] rows = new int[]{0, 1, 2, 3};
        int[] cols = new int[]{1, 1, 2, 2};
        for (int i = 0; i< rows.length; i++) {
            board.place(new Coordinates(rows[i],cols[i]), new Piece(color));
        }
        winRuler = new WinRuler(board,color);
        Assertions.assertTrue(winRuler.blackVictoryCheck());
    }

    @Test
    @DisplayName("White win check Test")
    void whiteTest()
    {
        color = Color.WHITE;
        int[] rows = new int[]{1, 1, 2, 3};
        int[] cols = new int[]{0, 1, 2, 3};
        for (int i = 0; i< rows.length; i++) {
            board.place(new Coordinates(rows[i],cols[i]), new Piece(color));
        }
        winRuler = new WinRuler(board,color);
        Assertions.assertTrue(winRuler.whiteVictoryCheck());
    }


    @ParameterizedTest
    @DisplayName("Generic case of win check")
    @ValueSource(booleans = {true,false})
    void winTest(boolean input) {

        if (input) {
            System.out.println("Black pieces");
            color = BLACK;
        } else  {
            System.out.println("White pieces");
            color = WHITE;
        }

        int[] rows = new int[]{0, 0, 1, 2, 3, 3};
        int[] cols = new int[]{1, 3, 1, 2, 0, 2};


        for (int i = 0; i< rows.length; i++) {
            board.place(new Coordinates(rows[i],cols[i]), new Piece(color));
        }
        winRuler = new WinRuler(board,color);

        if (input) {
            Assertions.assertTrue(winRuler.winCheck());
        } else  {
            Assertions.assertFalse(winRuler.winCheck());
        }

    }


}