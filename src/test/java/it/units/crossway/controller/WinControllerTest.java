package it.units.crossway.controller;

import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;
import it.units.crossway.model.Piece;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

class WinControllerTest {

    WinController winController;
    Board board;
    /*Come faccio a fare il test sui due colori?*/
    Color color = Color.BLACK;

    @BeforeEach
    @DisplayName("WinController test on 3x3 board")
    void setUp() {
        board = new Board(3,3);

        int[] rows = new int[]{0, 2};
        int[] cols = new int[]{1, 2};

        for (int i = 0; i< rows.length; i++) {
            board.place(new Coordinates(rows[i],cols[i]), new Piece(color));
        }
        winController = new WinController(board,color);
    }

    @Test
    @DisplayName("Enough pieces")
    void enoughPieces()
    {
        board.place(new Coordinates(1,1), new Piece(color));
        Assertions.assertTrue(winController.minNofPieces());
    }

    @Test
    @DisplayName("One piece for each")
    void oneForEachRowOrColumn()
    {
        board.place(new Coordinates(1,1), new Piece(color));
        if (color.equals(Color.BLACK)) {
            Assertions.assertTrue(winController.blackCheck());
        } else {
            Assertions.assertFalse(winController.whiteCheck());
        }
    }


    @Test
    @DisplayName("Win check")
    void winTest() {
        board.place(new Coordinates(1,1), new Piece(color));
        Assertions.assertTrue(winController.check());
    }


}