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

    public Coordinates getDiagonalNeighbours(Direction direction) throws RuntimeException {
        switch (direction) {
            case NORTH_WEST: {
                return new Coordinates(row - 1, column - 1);
            }
            case NORTH_EAST: {
                return new Coordinates(row - 1, column + 1);
            }
            case SOUTH_WEST: {
                return new Coordinates(row + 1, column - 1);
            }
            case SOUTH_EAST: {
                return new Coordinates(row + 1, column + 1);
            }
        }
        throw new RuntimeException();
    }

    public Coordinates getVerticalNeighbours(Direction direction) throws RuntimeException {
        switch (direction) {
            case NORTH_WEST:
            case NORTH_EAST: {
                return new Coordinates(row - 1, column);
            }
            case SOUTH_WEST:
            case SOUTH_EAST: {
                return new Coordinates(row + 1, column);
            }
        }
        throw new RuntimeException();
    }

    public Coordinates getHorizontalNeighbours(Direction direction) throws RuntimeException {
        switch (direction) {
            case NORTH_WEST:
            case SOUTH_WEST: {
                return new Coordinates(row, column - 1);
            }
            case NORTH_EAST:
            case SOUTH_EAST: {
                return new Coordinates(row, column + 1);
            }
        }
        throw new RuntimeException();
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
