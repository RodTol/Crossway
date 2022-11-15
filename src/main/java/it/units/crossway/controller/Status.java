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
    public static Status won() {
        return new Status(Condition.WON);
    }
    public static Status not_placed() {return new Status(Condition.NOT_PLACED);}

}


