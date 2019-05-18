/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_07_CallBackInterface_GUI;

import Lektion_07_CallBackInterface_Facade.CallBackInterface;
import Lektion_07_CallBackInterface_Facade.FacadeWithCallback;
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

    private Thread facade;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        startButton.setDisable(false);
        stopButton.setDisable(true);
    }

    @FXML
    private void buttonAction(ActionEvent event) {
        if (event.getSource() == startButton) {
            facade = new FacadeWithCallback(this);
            facade.start();
            startButton.setDisable(true);
            stopButton.setDisable(false);
        } else {
            facade.interrupt();
            startButton.setDisable(false);
            stopButton.setDisable(true);
        }
    }

    @Override
    public void updateMessage(String message) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                textArea.appendText(message + "\n");
                if(!facade.isAlive()){
                    stopButton.fire();
                }
            }
        });
    }

    @Override
    public void updateImages(File i1, File i2) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                die1view.setImage(new Image(i1.toURI().toString()));
                die2view.setImage(new Image(i2.toURI().toString()));
            }
        });
    }

}
