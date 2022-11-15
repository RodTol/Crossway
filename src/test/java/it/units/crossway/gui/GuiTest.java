package it.units.crossway.gui;

import it.units.crossway.model.Coordinates;
import it.units.crossway.utils.Config;
import it.units.crossway.controller.Controller;
import it.units.crossway.controller.GameController;
import it.units.crossway.gui.BoardGui;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GuiTest {

    @Test
    void mouseMotion() {
    }

    @Test
    void Nodes_correct_coordinates() {
        Controller controller = new GameController();
        BoardGui boardGui = new BoardGui(controller);
        ArrayList<Integer> XNodePositions = boardGui.getXNodePositions();
        ArrayList<Integer> YNodePositions = boardGui.getYNodePositions();
        int[] test_r = {4 ,6 ,12, 15};
        int[] test_c = {1 ,11 ,14, 18};

        for (int i=0; i<4; i++ ) {
            assertEquals(Config.BOARD_MARGIN + test_r[i]*Config.CELL_SIZE, XNodePositions.get(test_r[i]));
            assertEquals(Config.BOARD_MARGIN + test_c[i]*Config.CELL_SIZE, YNodePositions.get(test_c[i]));
        }

    }

    @Test
    void Click_perform_place () {
        Coordinates test_point = new Coordinates(14, 18);
        Controller controller = new GameController();

        BoardGui boardGui = new BoardGui(controller);
        boardGui.handleMouseClicked(test_point);
        assertFalse(controller.getBoard().getNode(test_point).isNodeEmpty());
    }


}
