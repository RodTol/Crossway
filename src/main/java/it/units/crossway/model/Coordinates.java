package it.units.crossway.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Coordinates {

    private final int row;
    private final int column;

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

    public boolean isNeighbour(Coordinates other) {
        if (Math.abs(other.row - this.row) < 2 && Math.abs(other.column - this.column) < 2) {
            return !this.equals(other);
        }
        return false;
    }

    public Coordinates getNorthNeighbour() {
        return new Coordinates(row-1,column);
    }

    public Coordinates getNorthWestNeighbour() {
        return new Coordinates(row-1,column-1);
    }

    public Coordinates getNorthEastNeighbour() {
        return new Coordinates(row-1,column+1);
    }

    public Coordinates getEastNeighbour() {
        return new Coordinates(row,column+1);
    }

    public Coordinates getWestNeighbour() {
        return new Coordinates(row,column-1);
    }

    public Coordinates getSouthNeighbour() {
        return new Coordinates(row+1,column);
    }

    public Coordinates getSouthWestNeighbour() {
        return new Coordinates(row + 1, column - 1);
    }

    public Coordinates getSouthEastNeighbour() {
        return new Coordinates(row + 1, column + 1);
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
