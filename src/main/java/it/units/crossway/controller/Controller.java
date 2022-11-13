package it.units.crossway.controller;

import it.units.crossway.model.Board;
import it.units.crossway.model.PiecePosition;

import java.awt.*;

public interface Controller {
    public Board getBoard();

    Color getCurrentColor();

    boolean canPlace(Color playerColor, PiecePosition position);

    boolean place(Color playerColor, PiecePosition position);

    public void changeTurn();
}
