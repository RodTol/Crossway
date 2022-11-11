package it.units.crossway.model;

import static it.units.crossway.config.Config.*;

public class Board {

    /*Creation of matrices of references of NOde type*/
    Node[][] nodes =  new Node[N_ROWS][N_COLUMNS];

    public Board(int Nrows, int Ncolumns) {
        /*Creation of N_ROWS*N_COLUMNS instances*/
        for (int row = 0; row < Nrows; row++) {
            for (int col = 0; col < Ncolumns; col++) {
                nodes[row][col] = new Node(row,col);
            }
        }
    }

    public boolean getNodePlayable(int r, int c) {
        return nodes[r][c].isPlayable();
    }
}
