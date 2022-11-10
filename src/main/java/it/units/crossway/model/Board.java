package it.units.crossway.model;

import static it.units.crossway.config.Config.*;

public class Board {

    /*Creation of matrices of references of NOde type*/
    Node[][] nodes =  new Node[getN_Rows()][getN_Columns()];

    Board() {
        /*Creation of N_ROWS*N_COLUMNS instances*/
        for (int row = 0; row < nodes.length; row++) {
            for (int col = 0; col < nodes[row].length; col++) {
                nodes[row][col] = new Node(row,col);
            }
        }
    }

    boolean getNodePlayable(int r, int c) {
        return nodes[r][c].isPlayable();
    }
}
