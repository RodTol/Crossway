package it.units.crossway.launcher;

class Config {
    // when omitting the modifier, it is implicitly a package protected class.
    public static final int N_ROWS = 19;
    public static final int N_COLUMNS = 19;
    public static final int CELL_SIZE = 26;
    public static final int BOARD_WIDTH = (N_COLUMNS-1)*CELL_SIZE;
    public static final int BOARD_HEIGHT = BOARD_WIDTH;
    public static final int BOARD_MARGIN = 75;
    public static final int FRAME_WIDTH = BOARD_WIDTH+2*BOARD_MARGIN;
    public static final int FRAME_HEIGHT =FRAME_WIDTH+75;


}
