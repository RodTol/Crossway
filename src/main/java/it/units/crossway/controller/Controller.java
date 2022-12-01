package it.units.crossway.controller;

import it.units.crossway.gui.PieceGui;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;

public interface Controller {

    Player getCurrentPlayer();
    Board getBoard();
    void setNameWhitePlayer(String name);
    void setNameBlackPlayer(String name);

    Player getPlayer1();

    Player getPlayer2();

    boolean canPlace(Coordinates position);

    Status place(PieceGui piece);

    void reset();

    void applyPieRule();

    void changeTurnSurrender();
}
