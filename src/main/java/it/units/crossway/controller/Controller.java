package it.units.crossway.controller;

import it.units.crossway.gui.PieceGui;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;

import java.awt.*;

public interface Controller {

    Color getCurrentColor();
    Board getBoard();

    boolean canPlace(Coordinates position);

    Status place(PieceGui piece);
}
