package it.units.crossway.gui;

import it.units.crossway.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    private JFrame frame;
    private JPanel backgroundPanel;
    private StartingPanel startingPanel;
    private BoardPanel boardPanel;
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

        backgroundPanel = new JPanel();

        frame = new JFrame();
        cl = new PageViewer();

        backgroundPanel.setLayout(cl);
        backgroundPanel.add(startingPanel, "1");
        backgroundPanel.add(boardPanel, "2");

        cl.show(backgroundPanel,"1");

        setupFrame("Insert players names", 800, 400);
        frame.add(backgroundPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
