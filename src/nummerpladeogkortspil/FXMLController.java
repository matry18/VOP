/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nummerpladeogkortspil;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import opg2_numberplates.NumberPlates;

/**
 * FXML Controller class
 *
 * @author aalsc
 */
public class FXMLController implements Initializable {

    @FXML
    private Label lblOutput;
    @FXML
    private Button btnTjek;
    @FXML
    private TextField txtFld;
    
    private NumberPlates np;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        np = new NumberPlates();
    }    

    @FXML
    private void ButtonActionHandler(ActionEvent event) {
        lblOutput.setText(np.validate(txtFld.getText()));
    }
    
}
