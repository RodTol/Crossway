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
    private Point ghostPosition;

    public BoardGui(Controller controller) {
        super(new BorderLayout());
        this.controller = controller;
        this.ghostPosition= null;
        addMouseMotionListener(new BoardMouseMotionListener());
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        drawVerticalLines(g);
        drawHorizontalLines(g);
        drawGhost(g);
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

    private void drawGhost(Graphics g) {
        System.err.println(ghostPosition);
        if (ghostPosition != null) {
            Color color = Color.RED;
            g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 70));
            Point point = positionToNodePx(ghostPosition);

            //x,y are not the center of the circle but top left corner, so we have to convert to proper position
            int x = point.x - (PIECE_SIZE / 2);
            int y = point.y - (PIECE_SIZE / 2);
            g.fillOval(x, y, PIECE_SIZE, PIECE_SIZE);
        }
    }


    private Point positionToNodePx(Point currentPosition) {
        return new Point(100,100);
    }


    private class BoardMouseMotionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            // not needed in our case
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            Point point = e.getPoint();
            Point newPosition = positionToNodePx(point);
            if (!newPosition.equals(ghostPosition)) {
                ghostPosition = newPosition;
                repaint();
            }
        }

    }



}



