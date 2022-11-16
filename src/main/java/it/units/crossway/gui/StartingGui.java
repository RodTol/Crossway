package it.units.crossway.gui;

import it.units.crossway.controller.Controller;

public class StartingGui {
    private Controller controller;

    public StartingGui(Controller controller) {
        this.controller = controller;
    }

    void handleInsert(String name) {
        /*Va gestito se inserisco il bianco o il nero*/
        controller.setNameWhitePlayer(name);
    }

    /*Insert Gui method*/
}
