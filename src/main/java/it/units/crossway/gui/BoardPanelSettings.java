package it.units.crossway.gui;

public class BoardPanelSettings {
    private final int margin;
    private final int height;
    private final int width;
    private final int cellSize;
    private final int backgroundPositionX;
    private final int backgroundPositionY;
    private static final int extraHeight = 75;
    private static final int PIECE_SIZE = 20;

    public BoardPanelSettings(int boardMargin, int boardHeight, int boardWidth, int cellSize) {
        this.margin = boardMargin;
        this.height = boardHeight + 2*boardMargin + extraHeight ;
        this.width = boardWidth + 2*boardMargin;
        this.cellSize = cellSize;
        this.backgroundPositionX = margin-40;
        this.backgroundPositionY = margin-40;

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
    public int getBackgroundPositionX() {
        return backgroundPositionX;
    }
    public int getBackgroundPositionY() {
        return backgroundPositionY;
    }
    public int getExtraHeight() {return  extraHeight; }
    public int getPieceSize() {return PIECE_SIZE; }
}
