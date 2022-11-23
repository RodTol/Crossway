package it.units.crossway.gui;

public class BoardPanelSettings {
    private final int margin;
    private final int height;
    private final int width;
    private final int cellSize;

    public BoardPanelSettings(int boardMargin, int boardHeight, int boardWidth, int cellSize) {
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
