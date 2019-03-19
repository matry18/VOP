/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lektion.pkg11.flashingtext;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author erso
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label funLabel;
    private String text;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnStop;
    @FXML
    private RadioButton rb100;
    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton rb200;
    @FXML
    private RadioButton rb400;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        thread.setDaemon(true);
        thread.start();

    }



    private Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    if (funLabel.getText().trim().length() == 0) {
                        text = "Programming is fun";
                    } else {
                        text = "";
                    }
                    System.out.println("Flash: " + text);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            funLabel.setText(text);
                        }
                    });

                    if (rb100.isSelected()) { 
                        Thread.sleep(100);
                    } else if (rb400.isSelected()) {
                        Thread.sleep(400);
                    }
                    else {
                        Thread.sleep(200);
                    }
                }
            } catch (InterruptedException ex) {
            }

        }

    });

    @FXML
    private void handleStartButtonAction(ActionEvent event) {
        
    }

    @FXML
    private void handleStopButtonAction(ActionEvent event) {
        thread.interrupt();
    }
}
