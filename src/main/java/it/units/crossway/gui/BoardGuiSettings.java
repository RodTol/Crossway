package it.units.crossway.gui;

import it.units.crossway.controller.Controller;

public class BoardGuiSettings {
    private final int margin;
    private final int height;
    private final int width;
    private final int cellSize;

    public BoardGuiSettings(int boardMargin, int boardHeight, int boardWidth, int cellSize) {
        this.margin = boardMargin;
        this.height = boardHeight;
        this.width = boardWidth;
        this.cellSize = cellSize;
    }

    public int getMargin() {
        return margin;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getCellSize() {
        return cellSize;
    }
}
