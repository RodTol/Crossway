package it.units.crossway.controller;

import it.units.crossway.model.Coordinates;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.awt.*;

public class Player {
    private final int id;
    private final Color color;
    private String name;

    public Player(int id, Color color) {
        this.id = id;
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Player o = (Player) obj;
        return new EqualsBuilder()
                .append(color, o.color)
                .append(name, o.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(color)
                .append(name)
                .toHashCode();
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
