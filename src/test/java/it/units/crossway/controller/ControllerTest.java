package it.units.crossway.controller;

import it.units.crossway.controller.Controller;
import it.units.crossway.controller.GameController;
import it.units.crossway.model.PiecePosition;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest {

    @Test
    void colorIsBlac() {
        Controller controller = new GameController();
        assertEquals(controller.getCurrentColor(), Color.BLACK);
    }

    @Test void canPlace() {
        Controller controller = new GameController();
        assertTrue(controller.canPlace(Color.BLACK, new PiecePosition(1,3)));
    }

}
