package it.units.crossway.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

public class Coordinates {

    private int row;
    private int column;

    public Coordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    /*Da decidere di chi sarà*/
    public boolean isNeighbour(Coordinates other) {
        if (Math.abs(other.row - this.row) < 2 && Math.abs(other.column - this.column) < 2) {
            return !this.equals(other);
        }
        return false;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coordinates)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Coordinates o = (Coordinates) obj;
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
