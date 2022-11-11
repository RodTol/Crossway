package it.units.crossway.controller;

import it.units.crossway.controller.Controller;
import it.units.crossway.controller.GameController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest {

    @Test
    void create_board() {
        Controller controller = new GameController();
        assertTrue(controller.getBoard().getNodePlayable(1,1));
    }

}
