package it.units.crossway.config;

public class Config {
    private static final int N_ROWS = 19;
    private static final int N_COLUMNS = N_ROWS;

    public static final int BOARD_WIDTH = 500;
    public static final int BOARD_HEIGHT = BOARD_WIDTH;

    private static final int FRAME_WIDTH = BOARD_WIDTH + 20;
    private static final int FRAME_HEIGHT = BOARD_HEIGHT + 40;

    private static final int CELL_SIZE = BOARD_WIDTH/N_COLUMNS;



    public static int getN_Rows() {
        return N_ROWS;
    }
    public static int getN_Columns() {
        return N_COLUMNS;
    }

    public static int getFrameWidth() { return FRAME_WIDTH; }
    public static int getFrameHeight() { return FRAME_HEIGHT; }

    public static int getBoardWidth() { return BOARD_WIDTH; }
    public static int getBoardHeight() { return BOARD_HEIGHT; }

    public static int getCellSize() { return CELL_SIZE; }
}
