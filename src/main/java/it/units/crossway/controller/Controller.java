package it.units.crossway.controller;

import it.units.crossway.gui.PieceGui;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;

import java.awt.*;

public interface Controller {
    public Board getBoard();

    Color getCurrentColor();

    boolean canPlace(Coordinates position);

    Status place(PieceGui piece);
}
