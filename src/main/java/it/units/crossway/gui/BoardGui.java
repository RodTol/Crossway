package it.units.crossway.gui;

import it.units.crossway.config.Config;
import it.units.crossway.controller.Controller;
import it.units.crossway.model.Piece;
import it.units.crossway.model.PiecePosition;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardGui extends JPanel {
    private static final int PIECE_SIZE = 20;
    private Controller controller;

    private Point ghostPosition;

    private Color playerColor;

    private List<PieceGui> pieces;

    public BoardGui(Controller controller) {
        super(new BorderLayout());
        this.controller = controller;
        this.ghostPosition= null;
        this.playerColor = controller.getCurrentColor();
        this.pieces = new ArrayList<>();
        addMouseMotionListener(new BoardMouseMotionListener());
        addMouseListener(new BoardMouseClickListener());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        drawVerticalLines(g);
        drawHorizontalLines(g);
        drawGhost(g);
        drawPieces(g);
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
        //System.err.println(ghostPosition);
        if (ghostPosition != null) {
            g.setColor(new Color(playerColor.getRed(), playerColor.getGreen(), playerColor.getBlue(), 70));
            Point point = positionToNodePx(ghostPosition);

            //x,y are not the center of the circle but top left corner, so we have to convert to proper position
            int x = point.x - (PIECE_SIZE / 2);
            int y = point.y - (PIECE_SIZE / 2);
            g.fillOval(x, y, PIECE_SIZE, PIECE_SIZE);
        }
    }

    private void drawPieces(Graphics g) {
        for (PieceGui piece : pieces) {
            g.setColor(piece.getColor());
            Point point = nodePositionToPx(piece.getPosition());
            int x = point.x - (PIECE_SIZE / 2);
            int y = point.y - (PIECE_SIZE / 2);
            g.fillOval(x, y, PIECE_SIZE, PIECE_SIZE);
        }
    }

    private Point positionToNodePx(Point currentPosition) {
        ArrayList<Integer> XNodePositions = getXNodePositions();
        int xminDistance = 10000;
        int ClosestXPos = 0;
        for (int x : XNodePositions) {
            if (Math.abs(x - currentPosition.x) < xminDistance) {
                xminDistance = Math.abs(x - currentPosition.x);
                ClosestXPos = x;
            }
        }
        ArrayList<Integer> YNodePositions = getYNodePositions();
        int yminDistance = 10000;
        int ClosestYPos = 0;
        for (int y : YNodePositions) {
            if (Math.abs(y - currentPosition.y) < yminDistance) {
                yminDistance = Math.abs(y - currentPosition.y);
                ClosestYPos = y;
            }
        }
        return new Point(ClosestXPos, ClosestYPos);
    }

    private PiecePosition nodePxToPosition(Point node) {
        int row = (int) ((node.getX() - Config.BOARD_MARGIN) / Config.CELL_SIZE)+1;
        int column = (int) ((node.getY() - Config.BOARD_MARGIN) / Config.CELL_SIZE)+1;

        PiecePosition newPoint = new PiecePosition(row, column);
        System.out.println(" px-> pos -------------- ");
        System.out.println(node);
        System.out.println(newPoint);
        return new PiecePosition(row, column);
    }

    private Point nodePositionToPx(PiecePosition position) {
        int Xpx = Config.BOARD_MARGIN + Config.CELL_SIZE * (position.getRow()-1);
        int Ypx = Config.BOARD_MARGIN + Config.CELL_SIZE * (position.getColumn()-1);

        Point newPoint = new Point(Xpx, Ypx);
        System.out.println(" pos -> px --___________ ");
        System.out.println(position);
        System.out.println(newPoint);

        return new Point(Xpx,Ypx);
    }

    private ArrayList<Integer> getXNodePositions() {
        ArrayList<Integer> XNodePos = new ArrayList<Integer>();
        for (int x=Config.BOARD_MARGIN; x<=Config.BOARD_WIDTH; x+=Config.CELL_SIZE) {
            XNodePos.add(x);
        }
        return XNodePos;
    }

    private ArrayList<Integer> getYNodePositions() {
        ArrayList<Integer> YNodePos = new ArrayList<Integer>();
        for (int y=Config.BOARD_MARGIN; y<= Config.BOARD_HEIGHT; y+=Config.CELL_SIZE) {
            YNodePos.add(y);
        }
        return YNodePos;
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
                PiecePosition position = nodePxToPosition(newPosition);
                if (controller.canPlace(playerColor, position)) {
                    ghostPosition = newPosition;
                }
                else {
                    ghostPosition = null;
                }
                repaint();
            }
        }
    }


    private class BoardMouseClickListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            Point node = e.getPoint();
            PiecePosition position =  nodePxToPosition(positionToNodePx(node));
            if (controller.canPlace(playerColor, position)) {
                Status status = controller.place();
                switch (status.getCondition()) {
                    case PLACED :
                        PlacedInfo statusInfo = status.getCondition().getInfo();
                        pieces.add(new PieceGui(playerColor, position));
                        playerColor = statusInfo.getCurrentColor();    // bc place changes controller color, now I update playerColor in gui
                        repaint();
                        break;
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }



}



