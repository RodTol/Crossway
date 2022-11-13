package it.units.crossway.exceptions;

public class NullPieceException extends Exception {
    public NullPieceException() {
        super("Node is empty");
    }
}
