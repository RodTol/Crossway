package it.units.crossway.gui;

import it.units.crossway.controller.Controller;

import javax.swing.JPanel;
import java.awt.*;

public class BoardGui extends JPanel {
    private static final int PIECE_SIZE = 40;
    private Controller controller;

    public BoardGui(Controller controller) {
        super(new BorderLayout());
        this.controller = controller;
    }

}
