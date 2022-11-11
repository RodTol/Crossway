package it.units.crossway.gui;

import it.units.crossway.config.Config;
import it.units.crossway.controller.Controller;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class BoardGui extends JPanel {
    private static final int PIECE_SIZE = 40;
    private Controller controller;

    public BoardGui(Controller controller) {
        super(new BorderLayout());
        this.controller = controller;
        addMouseMotionListener(new BoardMouseMotionListener());
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        drawVerticalLines(g);
        drawHorizontalLines(g);

    }

    private void drawVerticalLines(Graphics g) {
        for (int x = Config.CELL_SIZE; x < Config.BOARD_HEIGHT; x += Config.CELL_SIZE) {
            g.drawLine(x, 0, x, Config.BOARD_HEIGHT);
        }
    }

    private void drawHorizontalLines(Graphics g) {
        for (int y = Config.CELL_SIZE; y < Config.BOARD_WIDTH; y += Config.CELL_SIZE) {
            g.drawLine(0, y, Config.BOARD_HEIGHT, y);
        }
    }



    private static class BoardMouseMotionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            // not needed in our case
        }

        public void mouseMoved(MouseEvent e) {
            System.out.println(e.getPoint());
        }
    }
}



