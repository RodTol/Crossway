package it.units.crossway.gui;

import it.units.crossway.config.Config;
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

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        drawVerticalLines(g);
        //drawHorizontalLines(g);

    }

    private void drawVerticalLines(Graphics g) {
        for (int x = Config.getCellSize(); x < Config.getBoardHeight(); x += Config.getCellSize()){
            g.drawLine(x, 0, x, Config.getBoardHeight());
        }
    }
}
