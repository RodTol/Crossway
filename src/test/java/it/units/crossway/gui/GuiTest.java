package it.units.crossway.gui;

import it.units.crossway.launcher.gui.BoardGui;
import it.units.crossway.launcher.gui.BoardGuiSettings;
import it.units.crossway.controller.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GuiTest {

    private BoardGui boardGui;
    @BeforeEach
    public void setup() {
        Controller controller = Mockito.mock(Controller.class);   // to mimic a controller object.
        boardGui = new BoardGui(controller, new BoardGuiSettings(1, 40, 35, 2));
    }

    @Test
    void mouseMotion() {
    }

    @Test
    void Nodes_correct_coordinates() {
        ArrayList<Integer> XNodePositions = boardGui.getXNodePositions();
        ArrayList<Integer> YNodePositions = boardGui.getYNodePositions();
        int[] test_r = {4 ,6 ,12, 15};
        int[] test_c = {1 ,11 ,14, 18};

        for (int i=0; i<4; i++ ) {
            assertEquals(1 + test_r[i]*2, XNodePositions.get(test_r[i]));
            assertEquals(1 + test_c[i]*2, YNodePositions.get(test_c[i]));
        }

    }

//    @Test
//    void Click_perform_place () {
//        Coordinates test_point = new Coordinates(14, 18);
//        boardGui.handleMouseClicked(test_point);
//        assertFalse(controller.getBoard().getNode(test_point).isNodeEmpty());
//    }


}
