package it.units.crossway.gui;

import it.units.crossway.model.Coordinates;

import java.awt.*;

public class PieceGui {
    private final Color color;
    private final Coordinates position;
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
