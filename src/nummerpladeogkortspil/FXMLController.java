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
<<<<<<< HEAD
<<<<<<< HEAD
    @FXML
    private TextArea txtOutputArea;
    @FXML
    private Button btnBland;
    private RadioButton rb50;
    private RadioButton rb100;
    private RadioButton rb250;

    private DeckOfCards deckOfCards;
    ToggleGroup btnGroup = new ToggleGroup();
=======
>>>>>>> parent of 6cabb98... RBToggleGroup
=======
>>>>>>> parent of 6cabb98... RBToggleGroup

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
<<<<<<< HEAD
<<<<<<< HEAD

    @FXML
    private void btnBlandButtonActionHandler(ActionEvent event) {
        if (rb50.isSelected()) {
            deckOfCards.shuffle(50);
        } else if (rb100.isSelected()) {
            deckOfCards.shuffle(100);
        } else {
            deckOfCards.shuffle(250);
        }
        txtOutputArea.setText(deckOfCards.toString());
    }
=======
=======
>>>>>>> parent of 6cabb98... RBToggleGroup
    
>>>>>>> parent of 6cabb98... RBToggleGroup
}
