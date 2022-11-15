package it.units.crossway.launcher.gui;

import it.units.crossway.model.Coordinates;

import java.awt.*;

public class PieceGui {
    private Color color;
    private Coordinates position;
    public PieceGui(Color color, Coordinates position) {
        this.color = color;
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public Coordinates getPosition() {
        return position;
    }
}
