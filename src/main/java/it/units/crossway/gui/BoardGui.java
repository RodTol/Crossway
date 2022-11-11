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
        for (int x = Config.getCellSize(); x < Config.getBoardHeight(); x += Config.getCellSize()) {
            g.drawLine(x, 0, x, Config.getBoardHeight());
        }
    }

    private void drawHorizontalLines(Graphics g) {
        for (int y = Config.getCellSize(); y < Config.getBoardWidth(); y += Config.getCellSize()) {
            g.drawLine(0, y, Config.getBoardHeight(), y);
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



