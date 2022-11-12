package it.units.crossway.gui;

import it.units.crossway.model.PiecePosition;

import java.awt.*;

public class PieceGui {
    private Color color;
    private PiecePosition position;

    public PieceGui(Color color, PiecePosition position) {
        this.color = color;
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public PiecePosition getPosition() {
        return position;
    }
}
