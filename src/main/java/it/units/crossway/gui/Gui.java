package it.units.crossway.gui;

import it.units.crossway.controller.Controller;
import it.units.crossway.controller.Status;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui {
    private JFrame frame;
    private JPanel backgroundPanel;
    private StartingPanel startingPanel;
    private BoardPanel boardPanel;
    private WinnerPanel winnerPanel;
    private BoardPanelSettings settings;
    private PageViewer cl;

    public Gui(Controller controller, BoardPanelSettings boardPanelSettings) {
        startingPanel = new StartingPanel(controller);
        startingPanel.setBackground(Color.LIGHT_GRAY);
        startingPanel.getLetSPlayButton().addActionListener(new letsPlayListener());
        startingPanel.getClearButton().addActionListener(new clearListener());

        settings = boardPanelSettings;
        boardPanel = new BoardPanel(controller, settings);
        boardPanel.setBackground(Color.LIGHT_GRAY);
        boardPanel.addMouseMotionListener(new BoardMouseMotionListener());
        boardPanel.addMouseListener(new BoardMouseClickListener());

        winnerPanel = new WinnerPanel(controller);

        backgroundPanel = new JPanel();

        frame = new JFrame();
        cl = new PageViewer();

        backgroundPanel.setLayout(cl);
        backgroundPanel.add(startingPanel, "1");
        backgroundPanel.add(boardPanel, "2");
        backgroundPanel.add(winnerPanel,"3");

        cl.show(backgroundPanel,"1");

        setupFrame("Insert players names", 800, 400);
        frame.add(backgroundPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    private void setupFrame(String title, int x_location, int y_location) {
        frame.setTitle(title);
        frame.setResizable(false);
        frame.setLocation(x_location, y_location);
    }

    private class letsPlayListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (startingPanel.handleLetSPlay()) {
                boardPanel.drawNames();
                cl.show(backgroundPanel, "2");
                setupFrame("Crossway", 750, 200);
                frame.pack();
            }
        }
    }

    private class clearListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            startingPanel.handleClear();
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
            Status status = boardPanel.handleMouseClicked(node);
            switch (status.getCondition()) {
                case WON:
                    winnerPanel.setCongratulations();
                    cl.show(backgroundPanel, "3");
                    frame.pack();
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

    private class PageViewer extends CardLayout {
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
}
