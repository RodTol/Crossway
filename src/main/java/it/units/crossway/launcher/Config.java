package it.units.crossway.launcher;

class Config {
    // when omitting the modifier, it is implicitly a package protected class.
    public static final int N_ROWS = 19;
    public static final int N_COLUMNS = 19;
    public static final int BOARD_WIDTH = 500;
    public static final int BOARD_HEIGHT = BOARD_WIDTH;
    public static final int CELL_SIZE = BOARD_WIDTH/N_COLUMNS;
    public static final int BOARD_MARGIN = (BOARD_HEIGHT - (N_ROWS-1)*CELL_SIZE)/2;
    public static final int FRAME_WIDTH = BOARD_WIDTH + 20;
    public static final int FRAME_HEIGHT = BOARD_HEIGHT + 40;
}
