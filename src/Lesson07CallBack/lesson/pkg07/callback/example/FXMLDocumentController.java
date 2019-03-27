/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson07CallBack.lesson.pkg07.callback.example;

import Lesson07CallBack.facade.CallBackInterface;
import Lesson07CallBack.facade.FacadeWithCallback;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author erso
 */
public class FXMLDocumentController implements Initializable, CallBackInterface {

    @FXML
    private TextArea textArea;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML
    private ImageView die1view;
    @FXML
    private ImageView die2view;

    private FacadeWithCallback facade;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        startButton.setDisable(false);
        stopButton.setDisable(true);
    }

    @FXML
    private void buttonAction(ActionEvent event) {
        if (event.getSource() == startButton) {
            facade = new FacadeWithCallback(this);
            facade.setDaemon(true);
            facade.start();
            startButton.setDisable(true);
            stopButton.setDisable(false);
// Initialize the facade and start it.
// handle access to the buttons
        } else {
            startButton.setDisable(false);
            stopButton.setDisable(true);
            facade.interrupt();
// Stop the facade
        }
    }

    @Override
    public void updateMessage(String message) {
// This is the implementation of the CallBack. Remember it is called from a Thread!
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                textArea.appendText(message + "\n");
                if (!facade.isAlive()) {
                    stopButton.fire();
                }
            }
        });

// append the message to the textArea
    }

    @Override
    public void updateImages(File i1, File i2) {
// change the pictures on the imageViews
        die1view.setImage(new Image(i1.toURI().toString()));
        die2view.setImage(new Image(i1.toURI().toString()));

    }

}
