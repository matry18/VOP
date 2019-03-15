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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import opg2_numberplates.NumberPlates;
import opg3_playingcards.DeckOfCards;

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
    @FXML
    private TextArea txtOutputArea;
    @FXML
    private Button btnBland;
    @FXML
    private RadioButton rb50;
    @FXML
    private RadioButton rb100;
    @FXML
    private RadioButton rb250;

    private DeckOfCards deckOfCards;
    ToggleGroup btnGroup = new ToggleGroup();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        np = new NumberPlates();
        deckOfCards = new DeckOfCards();
        txtOutputArea.setText(deckOfCards.toString());
        rb50.setToggleGroup(btnGroup);
        rb100.setToggleGroup(btnGroup);
        rb250.setToggleGroup(btnGroup);
    }

    @FXML
    private void ButtonActionHandler(ActionEvent event) {
        lblOutput.setText(np.validate(txtFld.getText()));
    }

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
}
