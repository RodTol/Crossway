package it.units.crossway.model;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class Node {
    private Piece piece;

    public Node() {
        piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isNodeEmpty(){
        if (this.piece == null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Node o = (Node) obj;
        return new EqualsBuilder()
                .append(piece, o.piece)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return piece.hashCode();
    }

}
