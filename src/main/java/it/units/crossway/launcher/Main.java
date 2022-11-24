package it.units.crossway.launcher;

import it.units.crossway.gui.BoardPanelSettings;
import it.units.crossway.gui.Gui;
import it.units.crossway.model.Board;
import it.units.crossway.controller.Controller;
import it.units.crossway.controller.GameController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

public class Main {

    private static void click(Component target, int x, int y) throws InterruptedException {
        MouseEvent press, release, click;
        Point point;
        long time;
        point = new Point(x, y);
        SwingUtilities.convertPointToScreen(point, target);
        time    = System.currentTimeMillis();
        press   = new MouseEvent(target, MouseEvent.MOUSE_PRESSED,  time, 0, x, y, point.x, point.y, 1, false, MouseEvent.BUTTON1);
        release = new MouseEvent(target, MouseEvent.MOUSE_RELEASED, time, 0, x, y, point.x, point.y, 1, false, MouseEvent.BUTTON1);
        click   = new MouseEvent(target, MouseEvent.MOUSE_CLICKED,  time, 0, x, y, point.x, point.y, 1, false, MouseEvent.BUTTON1);
        target.dispatchEvent(press);
        target.dispatchEvent(release);
        target.dispatchEvent(click);
        TimeUnit.SECONDS.sleep(4);
    }

    public static void main(String[] args) {
        Board board = new Board( Config.N_ROWS, Config.N_COLUMNS);
        Controller controller = new GameController(board);

        Gui gui = new Gui(controller, new BoardPanelSettings(Config.BOARD_MARGIN,
                Config.BOARD_HEIGHT, Config.BOARD_WIDTH, Config.CELL_SIZE));


        int[] x_moves = new int[] {120, 140, 160};
        int[] y_moves = new int[] {120,140, 160};

        for (int i = 0; i < x_moves.length; i++) {
            try {
                click(gui.getBoardPanel(), x_moves[i], y_moves[i]);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
