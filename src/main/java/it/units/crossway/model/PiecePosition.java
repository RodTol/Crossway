package it.units.crossway.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PiecePosition {

    private int row;
    private int column;

    public PiecePosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PiecePosition)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PiecePosition o = (PiecePosition) obj;
        return new EqualsBuilder()
                .append(row, o.row)
                .append(column, o.column)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(row)
                .append(column)
                .toHashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " +
                "x=" + row +
                ", y=" + column;
    }
}
