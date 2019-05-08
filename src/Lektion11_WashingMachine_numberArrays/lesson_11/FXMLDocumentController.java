/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson_11;

import facade.Facade;
import java.net.URL;
import java.util.Arrays;
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
import laundry_facade.LaundrySingleton;

/**
 *
 * @author aalsc
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    private Facade facade;
    @FXML
    private TextField txtSize;
    @FXML
    private TextField txtMax;
    @FXML
    private Button btnFillArray;
    @FXML
    private Button btnFillUnique;
    @FXML
    private TextArea txtOutput;
    @FXML
    private TextField txtDivisor;
    @FXML
    private Button bntSumOfDivisor;
    @FXML
    private RadioButton rb6kg;
    @FXML
    private RadioButton rb12kg;
    @FXML
    private RadioButton rbTørretumbler;
    @FXML
    private TextField txtProgramEllerMinutter;
    @FXML
    private TextField txtValgte;
    @FXML
    private ToggleGroup tg;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = new Facade();
        LaundrySingleton.getInstance().buildLaundry();
    }

    @FXML
    private void handleFillArrayButtonAction(ActionEvent event) {
        txtOutput.appendText(Arrays.toString(facade.fillArray(Integer.parseInt(txtSize.getText()), Integer.parseInt(txtMax.getText()))) + "\n");
    }

    @FXML
    private void handleFillUniqueArrayButtonAction(ActionEvent event) {
        txtOutput.appendText(Arrays.toString(facade.fillUniqueArray(Integer.parseInt(txtSize.getText()), Integer.parseInt(txtMax.getText()))) + "\n");
    }

    @FXML
    private void handleSumOfDivisorsButtonAction(ActionEvent event) {
        txtOutput.appendText("Sum of divisor: " + facade.sumOfDivisors(Integer.parseInt(txtDivisor.getText())) + "\n");
    }

    @FXML
    private void handleRBProgram(ActionEvent event) {
// if skal gå på valgte toggle btn evt kombineret med en && i forhold til inputs

int machineId;
int prog;
if(event.getSource() == rb6kg) {
    machineId = 0;
    prog = new Integer(txtProgramEllerMinutter.getText());
    txtValgte.setText(Double.toString(LaundrySingleton.getInstance().getPrice(machineId, prog))+" kr.");
} else if(event.getSource() == rb12kg) {
    machineId = 1;
    prog = new Integer(txtProgramEllerMinutter.getText());
    txtValgte.setText(Double.toString(LaundrySingleton.getInstance().getPrice(machineId, prog))+" kr.");
} else {
    machineId = 2;
    try {
        prog = new Integer(txtProgramEllerMinutter.getText());
        txtValgte.setText(Double.toString(LaundrySingleton.getInstance().getPrice(machineId, prog))+" kr.");
    } catch (Exception e) {
        System.out.println("Fejl ved læsning af minutter!");
    }
}
//        if (tg.getSelectedToggle() == rb6kg || tg.getSelectedToggle() == rb12kg || tg.getSelectedToggle() == rbTørretumbler && Integer.parseInt(txtProgramEllerMinutter.getText()) < 0) {
//            txtValgte.setText(LaundrySingleton.getInstance().getProgName(0, Integer.parseInt(txtProgramEllerMinutter.getText())));
//        } else if (Integer.parseInt(txtProgramEllerMinutter.getText()) <= 7) {
//            if (tg.getSelectedToggle() == rb6kg) {
//                txtValgte.setText(LaundrySingleton.getInstance().getProgName(0, Integer.parseInt(txtProgramEllerMinutter.getText())) + " : ");
//                txtValgte.appendText(String.format("%.2f", LaundrySingleton.getInstance().getPrice(0, Integer.parseInt(txtProgramEllerMinutter.getText()))) + " kr.");
//            }
//            if (tg.getSelectedToggle() == rb12kg) {
//                txtValgte.setText(LaundrySingleton.getInstance().getProgName(1, Integer.parseInt(txtProgramEllerMinutter.getText())) + " : ");
//                txtValgte.appendText(String.format("%.2f", LaundrySingleton.getInstance().getPrice(0, Integer.parseInt(txtProgramEllerMinutter.getText()))) + " kr.");
//
//            }
//
//        } else if (Integer.parseInt(txtProgramEllerMinutter.getText()) > 7) {
//            txtValgte.setText(LaundrySingleton.getInstance().getProgName(2, Integer.parseInt(txtProgramEllerMinutter.getText())) + " : ");
//            txtValgte.appendText(String.format("%.2f", LaundrySingleton.getInstance().getPrice(2, Integer.parseInt(txtProgramEllerMinutter.getText()))) + " kr.");
//        }

    }

}
