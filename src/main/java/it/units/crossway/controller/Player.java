package it.units.crossway.controller;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.awt.*;

public class Player {
    private final int id;
    private Color color;
    private String name;

    Player(int id, Color color) {
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

    int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    void setColor(Color color) {
        this.color = color;
    }

    void setName(String name) {
        this.name = name;
    }

}
