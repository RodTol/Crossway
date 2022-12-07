package it.units.crossway.gui;

import it.units.crossway.controller.Status;
import it.units.crossway.controller.Controller;
import it.units.crossway.model.Coordinates;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BoardPanel extends JPanel {
    private static final int PIECE_SIZE = 20;
    private final Controller controller;
    private final BoardPanelSettings settings;
    private Point ghostPosition;
    final private List<PieceGui> pieces;
    private JLabel player1Name;
    private JLabel player2Name;
    private final JButton pieRuleButton;
    private final JButton surrenderButton;
    //private Color currentPlayerColor = new Color(36,107,116);
    private final Color currentPlayerColor = new Color(119, 32, 41);

    private final ImageIcon background = new ImageIcon("Pictures/background.png");

    public BoardPanel(Controller controller, BoardPanelSettings settings) {
        this.setLayout(null);
        this.controller = controller;
        this.settings = settings;
        this.ghostPosition= null;
        this.pieces = new ArrayList<>();
        this.pieRuleButton = new JButton("Pie Rule");
        this.add(pieRuleButton);
        this.surrenderButton = new JButton("I give up!");
        this.add(surrenderButton);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(settings.getWidth()+2*settings.getMargin(), settings.getHeight()+2*settings.getMargin()+75);
    }

    /*Method to draw the lines*/
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background.getImage(), settings.getMargin()-40,settings.getMargin()-40,null);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1.5f));
        drawVerticalLines(g2d);
        drawHorizontalLines(g2d);
        drawGhost(g2d);
        drawPieces(g2d);
        drawNameDots(g2d);
        drawBoardReferences(g2d);
    }

    Point getGhostPosition() {
        return ghostPosition;
    }

    JButton getPieRuleButton() {
        return pieRuleButton;
    }

    JButton getSurrenderButton() {
        return surrenderButton;
    }


    void reset() {
        this.remove(player1Name);
        this.remove(player2Name);
        pieces.clear();
        surrenderButton.setVisible(false);
        pieRuleButton.setVisible(false);
        controller.reset();
    }

    private void drawBoardReferences(Graphics2D g) {
        StringBuilder sb = new StringBuilder();
        IntStream.range('A', 'Z').forEach(i -> {sb.append((char) i);});
        for (int letterIdx = 0; letterIdx < 19; letterIdx++) {
            g.setColor(Color.black);
            g.drawString(String.valueOf(letterIdx), settings.getMargin()+settings.getCellSize()*letterIdx-5, settings.getMargin()-10);
            g.drawString(String.valueOf(letterIdx), settings.getMargin()+settings.getCellSize()*letterIdx-5, settings.getMargin()+settings.getWidth()+20);

            g.drawString(String.valueOf(sb.charAt(letterIdx)), settings.getMargin()-15, settings.getMargin()+settings.getCellSize()*letterIdx+3);
            g.drawString(String.valueOf(sb.charAt(letterIdx)), settings.getMargin()+settings.getWidth()+10, settings.getMargin()+settings.getCellSize()*letterIdx+3);
        }
    }

    private void drawVerticalLines(Graphics2D g) {
        for (int x = settings.getMargin(); x < settings.getWidth()+settings.getMargin()+settings.getCellSize(); x += settings.getCellSize()) {
            g.drawLine(x, settings.getMargin(), x, settings.getHeight()+settings.getMargin());
        }
    }

    private void drawHorizontalLines(Graphics2D g) {
        for (int y = settings.getMargin(); y < settings.getHeight()+settings.getMargin()+settings.getCellSize(); y += settings.getCellSize()) {
            g.drawLine(settings.getMargin(), y, settings.getWidth()+settings.getMargin(), y);
        }
    }

    private void drawGhost(Graphics2D g) {
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
    private void drawPieces(Graphics2D g) {
        for (PieceGui piece : pieces) {
            g.setColor(piece.getColor());
            Point point = nodePositionToPx(piece.getPosition());
            int x = point.x - (PIECE_SIZE / 2);
            int y = point.y - (PIECE_SIZE / 2);
            g.fillOval(x, y, PIECE_SIZE, PIECE_SIZE);
        }
    }

    private void drawNameDots(Graphics2D g) {
        g.setColor(controller.getPlayer1().getColor());
        g.fillOval(50, 600, PIECE_SIZE, PIECE_SIZE);
        g.setColor(controller.getPlayer2().getColor());
        g.fillOval(50, 640, PIECE_SIZE, PIECE_SIZE);
    }
    void drawNames() {
        player1Name = new JLabel(controller.getPlayer1().getName());
        player1Name.setBounds(100, 595, 200, 30 );
        player1Name.setForeground(currentPlayerColor);
        player1Name.setFont(new Font("Helvetica", Font.BOLD, 18));
        this.add(player1Name);

        player2Name = new JLabel(controller.getPlayer2().getName());
        player2Name.setBounds(100, 635, 200, 30 );
        player2Name.setFont(new Font("Helvetica", Font.BOLD, 18));
        this.add(player2Name);
    }

    void handlePieRuleButton(){
        if(pieces.size() == 1) {
            pieRuleButton.setBounds(300, 615, 180, 40);
            pieRuleButton.setVisible(true);
        } else {
            pieRuleButton.setVisible(false);
        }
    }

    void showSurrenderButton() {
        if (pieces.size() >= 2) {
            surrenderButton.setBounds(300, 615, 180, 40);
            surrenderButton.setVisible(true);
        } else {
            surrenderButton.setVisible(false);
        }
    }
    Status handleSurrender() {
        controller.changeTurnSurrender();
        return Status.won();
    }

    private void highlightCurrentPlayerName(){
        if (controller.getCurrentPlayer().getId()==1){
            player1Name.setForeground(currentPlayerColor);
            player2Name.setForeground(Color.BLACK);
        }
        else{
            player2Name.setForeground(currentPlayerColor);
            player1Name.setForeground(Color.BLACK);
        }
    }

    /*This function compute the position of the nodes in coordinate format
     * for the x-axis. Package private*/
    ArrayList<Integer> getXNodePositions() {
        ArrayList<Integer> XNodePos = new ArrayList<>();
        for (int x=settings.getMargin(); x<=settings.getWidth()+settings.getMargin(); x+=settings.getCellSize()) {
            XNodePos.add(x);
        }
        return XNodePos;
    }
    /*This function compute the position of the nodes in coordinate format
     * for the y-axis. Package private*/
    ArrayList<Integer> getYNodePositions() {
        ArrayList<Integer> YNodePos = new ArrayList<>();
        for (int y=settings.getMargin(); y<= settings.getHeight()+settings.getMargin(); y+=settings.getCellSize()) {
            YNodePos.add(y);
        }
        return YNodePos;
    }

    /*This function takes Point and assign the nearest node position
    * in pixels*/
    Point closestNodeToPx(Point currentPosition) {
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

    /*This function convert pixels into coordinates (row,column) with
    * both extending from 0 to 18*/
    Coordinates nodePxToPosition(Point point) {
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

    public void callPieRule() {
        controller.applyPieRule();
        highlightCurrentPlayerName();
    }

    public Status handleMouseClicked(Point node) {
        if (pointIsInMouseBorderLimits(node)) {
            Coordinates position = nodePxToPosition(closestNodeToPx(node));
            PieceGui piece = new PieceGui(controller.getCurrentPlayer().getColor(), position);
            if (controller.canPlace(position)) {
                Status status = controller.place(piece);
                switch (status.getCondition()) {
                    case PLACED: {
                        pieces.add(piece);
                        handlePieRuleButton();
                        showSurrenderButton();
                        highlightCurrentPlayerName();
                        repaint();
                        return status;
                    }
                    case WON: {
                        pieces.add(piece);
                        return status;
                    }
                }
            }
        }
        return Status.not_placed();
    }

    public void handleMouseMoved(Point point) {
        if (pointIsInMouseBorderLimits(point)) {
            Point newPosition = closestNodeToPx(point);
            if (!newPosition.equals(getGhostPosition())) {
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

    private boolean pointIsInMouseBorderLimits(Point point) {
        if (settings.getMargin()-30<point.getX() && point.getX()<settings.getMargin()+settings.getWidth()+30 && settings.getMargin()-30<point.getY() && point.getY()<settings.getMargin()+settings.getWidth()+30) {
            return true;
        }
        return false;
    }
}



