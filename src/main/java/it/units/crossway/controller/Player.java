package it.units.crossway.controller;

import java.awt.*;

class Player {
    private final Color color;
    private String name;

    public Player(Color color) {
        this.color = color;
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
