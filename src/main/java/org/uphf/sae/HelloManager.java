package org.uphf.sae;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class HelloManager implements EventHandler {

    public HelloManager() {}
    @Override
    public void handle(Event e) {
        if (e.getSource() instanceof Button) {
            Button b= ((Button) e.getSource());
            if (b.getText().equals("Quitter")) {
                b.getScene().getWindow().hide();
            }
            else if (b.getText().equals("Recommencer")) {
            }
        }
    }
}