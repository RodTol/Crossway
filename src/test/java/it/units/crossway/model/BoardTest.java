package it.units.crossway.model;

import it.units.crossway.utilities.Graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;


import static java.awt.Color.BLACK;

import static java.awt.Color.WHITE;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;
    @BeforeEach
    public void setup() {
        board = new Board(5,5);
    }

    @Test
    @DisplayName("Initial board is empty")
    void initialNodesAreEmpty(){
        for (int row = 0; row < board.getNodes().length; row++) {
            for (int col = 0; col < board.getNodes()[row].length; col++) {
                assertTrue(board.getNodes()[row][col].isNodeEmpty());
            }
        }
    }

    @Test
    @DisplayName("Can place on a empty Board")
    void canPlaceOnEmptyBoard(){
        for (int row = 0; row < board.getNodes().length; row++) {
            for (int col = 0; col < board.getNodes()[row].length; col++) {
                Coordinates coord = new Coordinates(row, col);
                assertTrue(board.canPlace(coord, new Piece(BLACK)));
            }
        }
    }

    @Test
    @DisplayName("Cannot place on illegal position")
    void canPlaceIllegalPosition(){
        Coordinates cord1 = new Coordinates(1,1);
        Coordinates cord2 = new Coordinates(1,2);
        Coordinates cord3 = new Coordinates(2,1);
        Coordinates cord4 = new Coordinates(2,2);

        Piece piece1 = new Piece(BLACK);
        Piece piece2 = new Piece(WHITE);
        Piece piece3 = new Piece(WHITE);

        board.place(cord1, piece1);
        board.place(cord2, piece2);
        board.place(cord3, piece3);

        assertFalse(board.canPlace(cord4,new Piece(BLACK)));
    }

    @Test
    @DisplayName("Can place on legal position")
    void canPlaceLegalPosition(){
        Coordinates cord1 = new Coordinates(1,1);
        Coordinates cord2 = new Coordinates(1,2);
        Coordinates cord3 = new Coordinates(2,1);
        Coordinates cord4 = new Coordinates(2,2);

        Piece piece1 = new Piece(WHITE);
        Piece piece2 = new Piece(WHITE);
        Piece piece3 = new Piece(WHITE);

        board.place(cord1, piece1);
        board.place(cord2, piece2);
        board.place(cord3, piece3);

        assertTrue(board.canPlace(cord4,new Piece(BLACK)));
    }

    @Test
    @DisplayName("Place fills the node")
    void notEmptyNode(){
        Coordinates coordinates = new Coordinates(1,2);
        Piece piece = new Piece(Color.BLACK);
        board.place(coordinates, piece);
        assertFalse(board.getNodes()[coordinates.getRow()][coordinates.getColumn()].isNodeEmpty());
    }

    @ParameterizedTest
    @DisplayName("Counting pieces of the same color")
    @ValueSource(booleans = {true,false})
    void CountNumbOfPieces (boolean input) {
        Coordinates[] TestCoordinates = {new Coordinates(0,2), new Coordinates(1,2)
                , new Coordinates(2,2), new Coordinates(3,1), new Coordinates(4, 4)
        };
        Color color;
        if (input) {
            color = BLACK;
        } else  {
            color = WHITE;
        }

        for (Coordinates coordinates : TestCoordinates) {
            board.place(coordinates, new Piece(color));
        }

        assertEquals(5, board.numOfPlacedPiecesWithColor(color));
    }

    @ParameterizedTest
    @DisplayName("Piece in a row of the same color")
    @ValueSource(booleans = {true,false})
    void PiecesInARow (boolean input) {
        Coordinates[] TestCoordinates = {new Coordinates(1,0), new Coordinates(1,2)
                , new Coordinates(1,4), new Coordinates(2,1), new Coordinates(0, 4)
        };
        Color color;
        if (input) {
            color = BLACK;
        } else  {
            color = WHITE;
        }

        for (Coordinates coordinates : TestCoordinates) {
            board.place(coordinates, new Piece(color));
        }
        for (int i = 0; i < 3; i++) {
            assertEquals(TestCoordinates[i], board.piecesInRowWithColor(1,color).get(i));
        }
    }

    @ParameterizedTest
    @DisplayName("Piece in a column of the same color")
    @ValueSource(booleans = {true,false})
    void PiecesInAColumn (boolean input) {
        Coordinates[] TestCoordinates = {new Coordinates(1,2), new Coordinates(2,2)
                , new Coordinates(3,2), new Coordinates(4,2), new Coordinates(2, 1)
        };
        Color color;
        if (input) {
            color = BLACK;
        } else  {
            color = WHITE;
        }

        for (Coordinates coordinates : TestCoordinates) {
            board.place(coordinates, new Piece(color));
        }
        for (int i = 0; i < 4; i++) {
            assertEquals(TestCoordinates[i], board.piecesInColumnWithColor(2,color).get(i));
        }
    }

    @Test
    @DisplayName("toGraph Test")
    void graphCreation() {
        Coordinates[] TestCoordinates = {new Coordinates(0,2), new Coordinates(1,2)
        , new Coordinates(2,2), new Coordinates(3,1), new Coordinates(4, 4)
        };
        Graph testGraph = new Graph();

        for (Coordinates coordinates : TestCoordinates) {
            testGraph.insert(coordinates);
            board.place(coordinates, new Piece(BLACK));
        }

        assertEquals(testGraph, board.toGraph(BLACK));
    }

}
