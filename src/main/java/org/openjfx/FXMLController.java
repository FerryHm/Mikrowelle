package org.openjfx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import org.openjfx.backend.Display;
import org.openjfx.backend.Mikrowelle;

public class FXMLController implements Initializable {

    Mikrowelle mikrowelle = new Mikrowelle();

    @FXML
    private TextField displaytext;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displaytext.setEditable(false);
        displaytext.setText(mikrowelle.getDisplayContent());
    }

    public void loop() {

    }

    public void startPreset(ActionEvent actionEvent) {

        Button btn = (Button) actionEvent.getSource();
        String id = btn.getId();

        if (id.equals("mode1"))
            mikrowelle.mode1();
        if (id.equals("mode2"))
            mikrowelle.mode2();
        if (id.equals("mode3"))
            mikrowelle.mode3();
        if (id.equals("mode4"))
            mikrowelle.mode4();

        displaytext.setText(mikrowelle.getDisplayContent());
    }

    public void start(ActionEvent actionEvent) {
        mikrowelle.startTimer();
        displaytext.setText(mikrowelle.getDisplayContent());
    }

    public void stop(ActionEvent actionEvent) {
        mikrowelle.stopTimer();
        displaytext.setText(mikrowelle.getDisplayContent());
    }

    public void increase(ActionEvent actionEvent) {
        mikrowelle.increase();
        displaytext.setText(mikrowelle.getDisplayContent());
    }

    public void decrease(ActionEvent actionEvent) {
        mikrowelle.decrease();
        displaytext.setText(mikrowelle.getDisplayContent());
    }

    public void switchMode(ActionEvent actionEvent) {
        mikrowelle.switchMode();
        displaytext.setText(mikrowelle.getDisplayContent());
    }
}