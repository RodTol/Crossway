package it.units.crossway.controller;

import it.units.crossway.model.Coordinates;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest {

    @Test
    void colorIsBlack() {
        Controller controller = new GameController();
        assertEquals(controller.getCurrentColor(), Color.BLACK);
    }

    @Test void canPlace() {
        Controller controller = new GameController();
        assertTrue(controller.canPlace(new Coordinates(1,3)));
    }



}
