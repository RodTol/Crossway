package it.units.crossway.gui;

import it.units.crossway.controller.Condition;
import it.units.crossway.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class GameGui {
    private final JFrame frame;
    private final JPanel backgroundPanel;
    private final StartingPanel startingPanel;
    private final BoardPanel boardPanel;
    private final WinnerPanel winnerPanel;
    private final PageViewer cl;

    public GameGui(Controller controller, BoardPanelSettings boardPanelSettings) {
        startingPanel = new StartingPanel(controller);
        setupStartingPanel();

        boardPanel = new BoardPanel(controller, boardPanelSettings);
        setupBoardPanel();

        winnerPanel = new WinnerPanel(controller);
        setupWinnerPanel();

        backgroundPanel = new JPanel();
        frame = new JFrame();
        cl = new PageViewer();

        backgroundPanel.setLayout(cl);
        backgroundPanel.add(startingPanel, "1");
        backgroundPanel.add(boardPanel, "2");
        backgroundPanel.add(winnerPanel,"3");

        cl.show(backgroundPanel,"1");

        setupFrame("Insert players names");
        frame.add(backgroundPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void setupStartingPanel() {
        startingPanel.setBackground(Color.LIGHT_GRAY);
        startingPanel.getLetSPlayButton().addActionListener(new LetsPlayListener());
        startingPanel.getDemoButton().addActionListener(new DemoButtonListener());
        startingPanel.getClearButton().addActionListener(new ClearListener());
    }

    private void setupBoardPanel() {
        boardPanel.setBackground(Color.LIGHT_GRAY);
        boardPanel.addMouseMotionListener(new BoardMouseMotionListener());
        boardPanel.addMouseListener(new BoardMouseClickListener());
        boardPanel.getPieRuleButton().addActionListener(new PieRuleListener());
        boardPanel.getSurrenderButton().addActionListener(new SurrenderListener());
    }

    private void setupWinnerPanel() {
        winnerPanel.getClose().addActionListener(new CloseListener());
        winnerPanel.getRematch().addActionListener(new RematchListener());
    }

    private void setupFrame(String title) {
        frame.setTitle(title);
        frame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/4, dim.height/4);
    }

    private void resetGame() {
        boardPanel.reset();
    }

    private static class PageViewer extends CardLayout {
        public Dimension preferredLayoutSize(Container parent) {
            Component current = findCurrentComponent(parent);
            if (current != null) {
                Insets insets = parent.getInsets();
                Dimension pref = current.getPreferredSize();
                pref.width += insets.left + insets.right;
                pref.height += insets.top + insets.bottom;
                return pref;
            }
            return super.preferredLayoutSize(parent);
        }

        public Component findCurrentComponent(Container parent) {
            for (Component comp : parent.getComponents()) {
                if (comp.isVisible()) {
                    return comp;
                }
            }
            return null;
        }
    }

    private class LetsPlayListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (startingPanel.handleLetSPlay()) {
                boardPanel.drawNamesLabel();
                cl.show(backgroundPanel, "2");
                setupFrame("Crossway");
                frame.pack();
            }
        }
    }

    private class ClearListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            startingPanel.handleClear();
        }
    }


    private void clickSimulator(Component target, int x, int y) {
        MouseEvent click;
        Point point;
        long time;

        try {
            TimeUnit.MILLISECONDS.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        point = new Point(x, y);
        SwingUtilities.convertPointToScreen(point, target);
        time = System.currentTimeMillis();

        click = new MouseEvent(target, MouseEvent.MOUSE_CLICKED, time, 0, x, y, point.x, point.y, 1, false, MouseEvent.BUTTON1);
        target.dispatchEvent(click);
    }

    private void playDemo() {
        SwingWorker sw1 = new SwingWorker() {
            @Override
            protected Object doInBackground() {
                boardPanel.drawNamesLabel();
                cl.show(backgroundPanel, "2");
                setupFrame("Crossway");
                frame.pack();

                int[]  cols = {9,9,8,10,10,11,11,13,13,12,11,11,13,
                        12,12,11,9,10,10,11,12,11,10,11,11,10,9,
                        12,13,10,14,8,15,6,7,5,6,5,6,5,5,3,4,2,3,
                        2,2,1,2,3,5,4,6,4,4,2,3,1,1,16,16,18,17,
                        18,18,0};
                int[] rows = {8,9,9,8,7,6,7,7,8,8,8,9,6,6,5,5,10,
                        10,11,11,13,12,13,13,14,12,12,11,12,6,12,
                        13,12,9,8,7,8,8,10,10,11,12,10,9,11,11,10,
                        10,7,9,6,7,7,6,5,4,6,7,6,12,11,11,10,9,10,6};

                for (int i = 0; i < rows.length; i++) {
                    clickSimulator(boardPanel, 75+rows[i]*26, 75 +cols[i]*26);
                }

                boardPanel.addDemoEndingLabel();
                return null;
            }
        };

        sw1.execute();
    }


    private class DemoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (startingPanel.handleLetSPlay()) {
                for(Component c : boardPanel.getComponents()){
                    if(c instanceof JButton){
                        boardPanel.remove(c);
                    }
                }
                playDemo();
            }
        }
    }

    private class PieRuleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Pie Rule Button pressed!");
            boardPanel.handlePieRuleButton();
            boardPanel.getPieRuleButton().setVisible(false);
        }
    }

    private class SurrenderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (boardPanel.handleSurrenderButton() ==  Condition.WON) {
                winnerPanel.setCongratulations();
                cl.show(backgroundPanel, "3");
                frame.pack();
            }
        }
    }

    private class BoardMouseMotionListener implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {}
        @Override
        public void mouseMoved(MouseEvent e) {
            Point point = e.getPoint();
            boardPanel.handleMouseMoved(point);
        }
    }


    private class BoardMouseClickListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            Point node = e.getPoint();
            Condition condition = boardPanel.handleMouseClicked(node);
            if (condition == Condition.WON) {
                winnerPanel.setCongratulations();
                cl.show(backgroundPanel, "3");
                frame.pack();
            } else if (condition == Condition.NOT_PLACED) {
                boardPanel.handleNotPlaced();
            }

        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) { }
    }

    private class RematchListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            resetGame();
            cl.show(backgroundPanel,"1");
            frame.pack();
        }
    }

    private static class CloseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
