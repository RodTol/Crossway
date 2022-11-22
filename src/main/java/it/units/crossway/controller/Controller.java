package it.units.crossway.controller;

import it.units.crossway.gui.PieceGui;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;

import java.awt.*;

public interface Controller {

    Player getCurrentPlayer();
    Board getBoard();
    void setNameWhitePlayer(String name);
    void setNameBlackPlayer(String name);

    boolean canPlace(Coordinates position);

    Status place(PieceGui piece);
}
