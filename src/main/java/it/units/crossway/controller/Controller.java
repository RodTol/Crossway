package it.units.crossway.controller;

import it.units.crossway.gui.PieceGui;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;

public interface Controller {

    Player getCurrentPlayer();
    Board getBoard();
    Player getPlayer1();
    Player getPlayer2();

    void setNameWhitePlayer(String name);
    void setNameBlackPlayer(String name);

    boolean canPlace(Coordinates position);
    Condition place(PieceGui piece);

    void reset();
    void applyPieRule();
    void switchCurrentPlayer();
}
