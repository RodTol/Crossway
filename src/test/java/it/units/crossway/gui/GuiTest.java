package it.units.crossway.gui;

import it.units.crossway.controller.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test on Gui")
public class GuiTest {

    private BoardPanel boardPanel;
    @BeforeEach
    public void setup() {
        Controller controller = Mockito.mock(Controller.class);   // to mimic a controller object.
        boardPanel = new BoardPanel(controller, new BoardPanelSettings(1, 40, 35, 2));
    }

    @Test
    @DisplayName("Coordinates coherence")
    void Nodes_correct_coordinates() {
        ArrayList<Integer> XNodePositions = boardPanel.getXNodePositions();
        ArrayList<Integer> YNodePositions = boardPanel.getYNodePositions();
        int[] test_r = {4 ,6 ,12, 15};
        int[] test_c = {1 ,11 ,14, 18};

        for (int i=0; i<4; i++ ) {
            assertEquals(1 + test_r[i]*2, XNodePositions.get(test_r[i]));
            assertEquals(1 + test_c[i]*2, YNodePositions.get(test_c[i]));
        }

    }




}
