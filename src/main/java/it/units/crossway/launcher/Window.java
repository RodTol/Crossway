package it.units.crossway.launcher;

import javax.swing.*;
import java.awt.*;

public class Window {

    Frame frame = new JFrame();

    public Window (String Title, JPanel content, int Width, int Height) {
        frame.setTitle(Title);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(content, BorderLayout.CENTER);

        frame.setSize(new Dimension(Width, Height));
        frame.setLocation(500, 200);    // location where frame appears
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
