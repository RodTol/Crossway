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
        time = System.currentTimeMillis();

        click = new MouseEvent(target, MouseEvent.MOUSE_CLICKED, time, 0, x, y, point.x, point.y, 1, false, MouseEvent.BUTTON1);
        target.dispatchEvent(click);
        TimeUnit.MILLISECONDS.sleep(200);
    }


    public static void main(String[] args) throws InterruptedException {
        Board board = new Board(Config.N_ROWS, Config.N_COLUMNS);
        Controller controller = new GameController(board);

        Gui gui = new Gui(controller, new BoardPanelSettings(Config.BOARD_MARGIN,
                Config.BOARD_HEIGHT, Config.BOARD_WIDTH, Config.CELL_SIZE));


        while (gui.getCurrentPanel() == 1) {
            try {
                Thread.sleep(3000);
                //Any other code to execute after 5 min execution pause.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*Delta pixel = 19, (0,0) = (16,16)*/
       System.out.println("Robot starts playing");
        for (int i = 0; i < 19; i++) {
            click(gui.getBoardPanel(), 16+26*4, 16 + i*26);
            click(gui.getBoardPanel(), 16+26*5, 16 + i*26 );
        }
    }
}




