package it.units.crossway.controller;

public class Status {

    private Condition condition;

    private Status(Condition condition) {
        this.condition = condition;
    }

    public Condition getCondition() {
        return this.condition;
    }

    public static Status placed() {
        return new Status(Condition.PLACED);
    }
}

