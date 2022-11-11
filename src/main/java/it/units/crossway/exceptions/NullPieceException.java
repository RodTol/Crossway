package it.units.crossway.exceptions;

public class NullPieceException extends Exception {
    public NullPieceException(int r,int c) {
        super("Node is empty at "+ r + " " + c);
    }
}
