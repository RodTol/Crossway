package it.units.crossway.controller;

import it.units.crossway.launcher.gui.PieceGui;
import it.units.crossway.model.Coordinates;

import java.awt.*;

public interface Controller {

    Color getCurrentColor();

    boolean canPlace(Coordinates position);

    Status place(PieceGui piece);
}
