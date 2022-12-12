package it.units.crossway.controller;

import it.units.crossway.gui.PieceGui;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test on class GameController")
public class GameControllerTest {

    private GameController controller;
    private Board board;

    @BeforeEach
    public void setup() {
        board = Mockito.mock(Board.class);
        controller = new GameController(board);
    }

    @Test
    @DisplayName("Start color is black")
    void startColorIsBlack() {
        assertEquals(controller.getCurrentPlayer().getColor(), Color.BLACK);
    }

    @Test
    @DisplayName("canPlace test")
    void canPlace() {
        // I need to test that can place is called, and it outputs correct result
        // the fake board should show the behaviour of canPlace
        // here we are forcing a false behaviour of the board.canPlace
        Mockito.when(board.canPlace(Mockito.any(), Mockito.any())).thenReturn(false);
        assertFalse(controller.canPlace(new Coordinates(1,3)));
        Mockito.verify(board).canPlace(Mockito.any(), Mockito.any());
        // it verifies board.canPlace has been called once
        // First I verify the method returns the correct result
        // Second I verify the method is called
    }

    @Test
    @DisplayName("atLeastOnePlacement test on empty board")
    void atLeastOnePlacementEmptyBoard(){
        Board board1 = new Board(19,19);
        assertTrue(new GameController(board1).atLeastOnePlacement());
    }

    @Test
    @DisplayName("atLeastOnePlacement test on board with no valid placements")
    void atLeastOnePlacementNoPlacements(){
        Board board1 = new Board(3,3);
        GameController controller = new GameController(board1);
        controller.place(new PieceGui(Color.BLACK,new Coordinates(0,0)));
        controller.place(new PieceGui(Color.BLACK,new Coordinates(0,2)));
        controller.place(new PieceGui(Color.BLACK,new Coordinates(2,0)));
        controller.place(new PieceGui(Color.BLACK,new Coordinates(2,2)));
        controller.place(new PieceGui(Color.WHITE,new Coordinates(0,1)));
        controller.place(new PieceGui(Color.WHITE,new Coordinates(1,0)));
        controller.place(new PieceGui(Color.WHITE,new Coordinates(1,2)));
        controller.place(new PieceGui(Color.WHITE,new Coordinates(2,1)));
        assertFalse(controller.atLeastOnePlacement());
    }


}
