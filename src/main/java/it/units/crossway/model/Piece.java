package it.units.crossway.model;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.awt.*;

public class Piece {

    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Piece)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Piece o = (Piece) obj;
        return new EqualsBuilder()
                .append(color, o.color)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return color.hashCode();
    }

}
