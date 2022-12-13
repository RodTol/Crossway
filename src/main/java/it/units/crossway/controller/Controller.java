package it.units.crossway.controller;

import it.units.crossway.gui.PieceGui;
import it.units.crossway.model.Board;
import it.units.crossway.model.Coordinates;

public interface Controller {

    Player getCurrentPlayer();
    Player getPlayer1();
    Player getPlayer2();
    void switchCurrentPlayer();
    void setNameBlackPlayer(String name);
    void setNameWhitePlayer(String name);

    Board getBoard();
    boolean canPlace(Coordinates position);
    Condition place(PieceGui piece);

    void applyPieRule();
    void resetGame();
    void surrenderUpdater();
}
