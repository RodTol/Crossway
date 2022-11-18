package it.units.crossway.controller;

import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test on class GameController")
public class ControllerTest {

    private Controller controller;
    private Board board;

    @BeforeEach
    public void setup() {
        board = Mockito.mock(Board.class);   // it mimicks a board object. Note I don't need to pass nrows and ncol as arguments of board.
        controller = new GameController(board);
    }

    @Test
    @DisplayName("Start color is black")
    void startColorIsBlack() {
        assertEquals(controller.getCurrentColor(), Color.BLACK);
    }

    @Test
    @DisplayName("canPlace test")
    void canPlace() {
        // I need to test that can place is called and it outputs correct result
        // the fake board should show the behaviour of canPlace
        // here we are forcing a false behaviour of the board.canPlace
        Mockito.when(board.canPlace(Mockito.any(), Mockito.any())).thenReturn(false);
        assertFalse(controller.canPlace(new Coordinates(1,3)));
        Mockito.verify(board).canPlace(Mockito.any(), Mockito.any());
        // it verifies board.canPlace has been called once
        // First I verify the method returns the correct result
        // Second I verify the method is called
    }



}
