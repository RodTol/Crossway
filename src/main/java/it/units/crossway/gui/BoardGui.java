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
        for (int x = Config.BOARD_MARGIN; x < Config.BOARD_HEIGHT-Config.BOARD_MARGIN; x += Config.CELL_SIZE) {
            g.drawLine(x, Config.BOARD_MARGIN, x, Config.BOARD_HEIGHT-Config.BOARD_MARGIN);
        }
        g.drawLine(Config.BOARD_WIDTH-Config.BOARD_MARGIN, Config.BOARD_MARGIN, Config.BOARD_WIDTH-Config.BOARD_MARGIN, Config.BOARD_HEIGHT-Config.BOARD_MARGIN);
    }

    private void drawHorizontalLines(Graphics g) {
        for (int y = Config.BOARD_MARGIN; y < Config.BOARD_WIDTH-Config.BOARD_MARGIN; y += Config.CELL_SIZE) {
            g.drawLine(Config.BOARD_MARGIN, y, Config.BOARD_HEIGHT-Config.BOARD_MARGIN, y);
        }
        g.drawLine(Config.BOARD_MARGIN, Config.BOARD_HEIGHT-Config.BOARD_MARGIN, Config.BOARD_HEIGHT-Config.BOARD_MARGIN, Config.BOARD_HEIGHT-Config.BOARD_MARGIN);
    }



    private static class BoardMouseMotionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            // not needed in our case
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }


}



