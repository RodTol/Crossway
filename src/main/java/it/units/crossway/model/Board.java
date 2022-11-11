package it.units.crossway.model;

import static it.units.crossway.utils.Config.*;

public class Board {

    /*Creation of matrices of references of NOde type*/
    Node[][] nodes =  new Node[N_ROWS][N_COLUMNS];

    public Board() {
        /*Creation of N_ROWS*N_COLUMNS instances*/
        for (int row = 0; row < N_ROWS; row++) {
            for (int col = 0; col < N_COLUMNS; col++) {
                nodes[row][col] = new Node(row,col);
            }
        }
    }

    public boolean getNodePlayable(int r, int c) {
        return nodes[r][c].isPlayable();
    }

    public boolean isNodeEmpty(int r, int c) {
        if (nodes[r][c].getPiece()==null){return true;}
        else {return false;}
    }

    public void placePiece(int r, int c, boolean colour) {
        nodes[r][c].setPiece(new Piece(colour));
        /*Update playable state*/
    }
}
