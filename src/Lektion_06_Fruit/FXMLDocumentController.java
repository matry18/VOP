/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_06_Fruit;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author aalsc
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private Button btnStop1;
    @FXML
    private Button btnStop2;
    @FXML
    private Button btnStop3;
    @FXML
    private Button btnStart;
    @FXML
    private Label lblOutput;
    private javafx.scene.image.Image[] pics;
    @FXML
    private ImageView imgView1;
    @FXML
    private ImageView imgView2;
    @FXML
    private ImageView imgView3;
    private Thread t1;
    private Thread t2;
    private Thread t3;
    private int spinRunning;

    @FXML
    private void handleStop1ButtonAction(ActionEvent event) {
        t1.interrupt();
        btnStop1.setDisable(true);
    }

    @FXML
    private void handleStop2ButtonAction(ActionEvent event) {
        t2.interrupt();
        btnStop2.setDisable(true);
    }

    @FXML
    private void handleStop3ButtonAction(ActionEvent event) {
        t3.interrupt();
        btnStop3.setDisable(true);
    }

    @FXML
    private void handleStartButtonAction(ActionEvent event) {
        
            FruitRunnable fr1 = new FruitRunnable(1, 100, imgView1);
            FruitRunnable fr2 = new FruitRunnable(1, 120, imgView2);
            FruitRunnable fr3 = new FruitRunnable(1, 140, imgView3);
            t1 = new Thread(fr1);
            t2 = new Thread(fr2);
            t3 = new Thread(fr3);
            t1.setDaemon(true);
            t2.setDaemon(true);
            t3.setDaemon(true);
            t1.start();
            t2.start();
            t3.start();
            lblOutput.setText("Running");
            btnStop1.setDisable(false);
            btnStop2.setDisable(false);
            btnStop3.setDisable(false);
            btnStart.setDisable(true);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        pics = new Image[10];
        for (int i = 0; i < 10; i++) {
            pics[i] = new Image(new File("fruits" + i + ".png").toURI().toString());
        }
        imgView1.setImage(pics[0]);
        imgView2.setImage(pics[1]);
        imgView3.setImage(pics[2]);
    }

    public synchronized void aliveCount(boolean up) {
        if (up) {
            spinRunning++;
        } else {
            spinRunning--;
        }
        System.out.println("Alive: " + spinRunning);
        if (spinRunning == 0) {
            btnStart.setDisable(false);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (imgView1.getImage() == imgView2.getImage() && imgView1.getImage() == imgView3.getImage()) {
                        lblOutput.setText("3 ens: Jackpot");
                    } else if (imgView1.getImage() == imgView2.getImage() || imgView1.getImage() == imgView3.getImage() || imgView2.getImage() == imgView3.getImage()) {
                        lblOutput.setText("2 ens: Du vinder lidt");
                    } else {
                        lblOutput.setText("TABER!!!");
                    }
                }
            });
        }
    }

    public class FruitRunnable implements Runnable {

        private int i; //Index of current picture
        private long sleepTime;
        private boolean running;
        private ImageView iw;

        public FruitRunnable(int i, long sleepTime, ImageView iw) {
            this.i = i;
            this.sleepTime = sleepTime;
            this.iw = iw;
        }

        @Override
        public void run() {
            running = true;
            aliveCount(true);
            System.out.println("Thread has been started: " + Thread.currentThread());
            while (running) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        iw.setImage(pics[i]);
                        i = (i + 1) % pics.length;
                    }
                });
                synchronized (this) {
                    try {
//                    Thread.sleep(sleepTime);
                        wait(sleepTime);
                    } catch (InterruptedException ex) {
                        System.out.println("Interrupted: " + Thread.currentThread());
                        running = false;
                        aliveCount(false);
                    }
                }
            }
        }
    }
}
