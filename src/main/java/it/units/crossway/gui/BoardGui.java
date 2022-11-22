package it.units.crossway.gui;

import it.units.crossway.controller.Status;
import it.units.crossway.controller.Controller;
import it.units.crossway.model.Coordinates;
import it.units.crossway.controller.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class BoardGui extends JPanel {
    
    private static final int PIECE_SIZE = 20;
    private final Controller controller;
    
    private final BoardGuiSettings settings;
    private Point ghostPosition;
    private List<PieceGui> pieces;

    public BoardGui(Controller controller, BoardGuiSettings settings) {
        super(new BorderLayout());
        this.controller = controller;
        this.settings = settings;
        this.ghostPosition= null;
        this.pieces = new ArrayList<>();

        addMouseMotionListener(new BoardMouseMotionListener());
        addMouseListener(new BoardMouseClickListener());
    }

    /*Method to draw the lines*/
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
        for (int x = settings.getMargin(); x < settings.getHeight()-settings.getMargin(); x += settings.getCellSize()) {
            g.drawLine(x, settings.getMargin(), x, settings.getHeight()-settings.getMargin());
        }
        g.drawLine(settings.getWidth()-settings.getMargin(), settings.getMargin(), settings.getWidth()-settings.getMargin(), settings.getHeight()-settings.getMargin());
    }

    private void drawHorizontalLines(Graphics g) {
        for (int y = settings.getMargin(); y < settings.getWidth()-settings.getMargin(); y += settings.getCellSize()) {
            g.drawLine(settings.getMargin(), y, settings.getHeight()-settings.getMargin(), y);
        }
        g.drawLine(settings.getMargin(), settings.getHeight()-settings.getMargin(), settings.getHeight()-settings.getMargin(), settings.getHeight()-settings.getMargin());
    }

    private void drawGhost(Graphics g) {
        //Color playerColor = controller.getCurrentPlayer().getColor();
        Color playerColor = controller.getCurrentPlayer().getColor();
        if (ghostPosition != null) {
            g.setColor(new Color(playerColor.getRed(), playerColor.getGreen(), playerColor.getBlue(), 70));
            Point point = closestNodeToPx(ghostPosition);

            //x,y are not the center of the circle but top left corner, so we have to convert to proper position
            int x = point.x - (PIECE_SIZE / 2);
            int y = point.y - (PIECE_SIZE / 2);
            g.fillOval(x, y, PIECE_SIZE, PIECE_SIZE);
        }
    }

    /*This method draws all my placed pieces*/
    private void drawPieces(Graphics g) {
        for (PieceGui piece : pieces) {
            g.setColor(piece.getColor());
            Point point = nodePositionToPx(piece.getPosition());
            int x = point.x - (PIECE_SIZE / 2);
            int y = point.y - (PIECE_SIZE / 2);
            g.fillOval(x, y, PIECE_SIZE, PIECE_SIZE);
        }
    }

    /*This function compute the position of the nodes in coordinate format
     * for the x-axis. Package private*/
    ArrayList<Integer> getXNodePositions() {
        ArrayList<Integer> XNodePos = new ArrayList<>();
        for (int x=settings.getMargin(); x<=settings.getWidth(); x+=settings.getCellSize()) {
            XNodePos.add(x);
        }
        return XNodePos;
    }
    /*This function compute the position of the nodes in coordinate format
     * for the y-axis. Package private*/
    ArrayList<Integer> getYNodePositions() {
        ArrayList<Integer> YNodePos = new ArrayList<>();
        for (int y=settings.getMargin(); y<= settings.getHeight(); y+=settings.getCellSize()) {
            YNodePos.add(y);
        }
        return YNodePos;
    }

    /*This function takes Point and assign the nearest node position
    * in pixels*/
    private Point closestNodeToPx(Point currentPosition) {
        ArrayList<Integer> XNodePositions = getXNodePositions();
        int xMinDistance = 10000;
        int ClosestXPos = 0;
        for (int x : XNodePositions) {
            if (Math.abs(x - currentPosition.x) < xMinDistance) {
                xMinDistance = Math.abs(x - currentPosition.x);
                ClosestXPos = x;
            }
        }
        ArrayList<Integer> YNodePositions = getYNodePositions();
        int yMinDistance = 10000;
        int ClosestYPos = 0;
        for (int y : YNodePositions) {
            if (Math.abs(y - currentPosition.y) < yMinDistance) {
                yMinDistance = Math.abs(y - currentPosition.y);
                ClosestYPos = y;
            }
        }
        return new Point(ClosestXPos, ClosestYPos);
    }


    //HO INVERTITO QUESTI DUE PER FAR COMBACIARE LE COORDINATE
    /*Ha senso perchè gli assi vanno
    * ------------->  X
    * |
    * |
    * |
    * |
    * Y
    * Quindi le x sono le colonne e le y le righe*/

    /*This function convert pixels into coordinates (row,column) with
    * both extending from 0 to 18*/
    private Coordinates nodePxToPosition(Point point) {
        int row = (int) ((point.getX() - settings.getMargin()) / settings.getCellSize());
        int column = (int) ((point.getY() - settings.getMargin()) / settings.getCellSize());
        return new Coordinates(column, row);
    }

    /*Convert coordinates into pixels. Takes input with row and columns from 0 to 18*/
    private Point nodePositionToPx(Coordinates position) {
        int Xpx = settings.getMargin() + settings.getCellSize() * (position.getRow());
        int Ypx = settings.getMargin() + settings.getCellSize() * (position.getColumn());
        return new Point(Ypx,Xpx);
    }

    public void handleMouseClicked(Coordinates position) {
        PieceGui piece = new PieceGui(controller.getCurrentPlayer().getColor(), position);
        if (controller.canPlace(position)) {
            Status status = controller.place(piece);
            switch (status.getCondition()) {
                case PLACED :
                    pieces.add(piece);
                    /*System.out.println(controller.getCurrentColor() + " piece placed at "
                            + position.getRow() + " " + position.getColumn());*/
                    repaint();
                    break;
                case WON :
                    /*End-game*/
            }
        }
    }


    private class BoardMouseMotionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            // not needed in our case
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            Point point = e.getPoint();
            Point newPosition = closestNodeToPx(point);
            if (!newPosition.equals(ghostPosition)) {
                Coordinates position = nodePxToPosition(newPosition);
                if (controller.canPlace(position)) {
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
            Coordinates position =  nodePxToPosition(closestNodeToPx(node));
            handleMouseClicked(position);
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



