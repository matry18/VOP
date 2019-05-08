/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_12.lesson_12;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import Lektion_12.opg1_facade.SpecialNumbers;
import Lektion_12.opg2_polymorphi.CheckerInterface;
import Lektion_12.opg2_polymorphi.EvenChecker;
import Lektion_12.opg2_polymorphi.NumberCheckerFacade;
import Lektion_12.opg2_polymorphi.PrimeChecker;
import Lektion_12.opg2_polymorphi.SquareChecker;

/**
 *
 * @author aalsc
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private TextField txtInput;
    @FXML
    private TextField txtOutput;
    @FXML
    private Button btnIsEven;
    @FXML
    private Button btnIsPrime;
    @FXML
    private Button btnIsSquare;

    SpecialNumbers sn;
    @FXML
    private TextField txtInputMin;
    @FXML
    private TextField txtInputMax;
    @FXML
    private RadioButton rbEven;
    @FXML
    private ToggleGroup toggleGroup;
    @FXML
    private RadioButton rbPrime;
    @FXML
    private RadioButton rbSquare;
    @FXML
    private Button btnClear;

    NumberCheckerFacade ncf;
    @FXML
    private TextArea txtCNOutput;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sn = new SpecialNumbers();
        ncf = new NumberCheckerFacade();
        rbEven.setUserData(new EvenChecker());
        rbPrime.setUserData(new PrimeChecker());
        rbSquare.setUserData(new SquareChecker());
    }

    @FXML
    private void handleIsEvenButtonAction(ActionEvent event) {
        txtOutput.setText(txtInput.getText() + " is " + sn.isEven(Integer.parseInt(txtInput.getText())));
    }

    @FXML
    private void handleIsPrimeButtonAction(ActionEvent event) {
        txtOutput.setText(txtInput.getText() + " is " + sn.isPrime(Integer.parseInt(txtInput.getText())));
    }

    @FXML
    private void handleIsSquareButtonAction(ActionEvent event) {
        txtOutput.setText(txtInput.getText() + " is " + sn.isSquare(Integer.parseInt(txtInput.getText())));
    }

    @FXML
    private void handleRadioButtonAction(ActionEvent event) {
        CheckerInterface ci;
        LinkedList<Integer> resultList = new LinkedList<>(ncf.checkNumbers(Integer.parseInt(txtInputMin.getText()), Integer.parseInt(txtInputMax.getText()), (CheckerInterface) toggleGroup.getSelectedToggle().getUserData()));
        txtCNOutput.appendText(resultList.toString() + "\n" + resultList.size() + "\n");
    }

    @FXML
    private void handleClearButtonAction(ActionEvent event) {
        txtInputMin.clear();
        txtInputMax.clear();
        txtCNOutput.clear();
    }

}
