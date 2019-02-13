/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lektion1_shape;

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
import opg4_polymorphism.ShapeFacade;

/**
 *
 * @author aalsc
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private RadioButton rbEllipse;
    @FXML
    private RadioButton rbRectangle;
    @FXML
    private RadioButton rbCircle;
    @FXML
    private RadioButton rbSquere;
    @FXML
    private TextField txtFieldParameterOne;
    @FXML
    private TextField txtFieldParameterTwo;
    @FXML
    private TextArea txtAreaOutput;
    @FXML
    private Button btnGetInfo;
    
    ToggleGroup group = new ToggleGroup();
    
    private void handleButtonAction(ActionEvent event) {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rbEllipse.setUserData(ShapeFacade.SHAPES.ELLIPSE);
        rbRectangle.setUserData(ShapeFacade.SHAPES.RECTANGLE);
        rbCircle.setUserData(ShapeFacade.SHAPES.CIRCLE);
        rbSquere.setUserData(ShapeFacade.SHAPES.SQUERE);
        
    }    


    @FXML
    private void handleGetInfoButtonAction(ActionEvent event) {
       if (group.getSelectedToggle().getUserData() == ShapeFacade.SHAPES.ELLIPSE ||
               group.getSelectedToggle().getUserData() == ShapeFacade.SHAPES.RECTANGLE) {
           txtAreaOutput.setText(ShapeFacade.getInstance().getShapeInfo((ShapeFacade.SHAPES)group.getSelectedToggle().getUserData(), new double[]{Double.parseDouble(txtFieldParameterOne.getText()),Double.parseDouble(txtFieldParameterTwo.getText())}));
       } else if (group.getSelectedToggle().getUserData() == ShapeFacade.SHAPES.CIRCLE || 
               group.getSelectedToggle().getUserData() == ShapeFacade.SHAPES.SQUERE) {
           txtAreaOutput.setText(ShapeFacade.getInstance().getShapeInfo((ShapeFacade.SHAPES)group.getSelectedToggle().getUserData(), new double[]{Double.parseDouble(txtFieldParameterOne.getText())}));
       }
    }

    @FXML
    private void handleRBButtonAction(ActionEvent event) {
        rbEllipse.setToggleGroup(group);
        rbRectangle.setToggleGroup(group);
        rbCircle.setToggleGroup(group);
        rbSquere.setToggleGroup(group);
        if (group.getSelectedToggle().getUserData() == ShapeFacade.SHAPES.ELLIPSE ||
                group.getSelectedToggle().getUserData() == ShapeFacade.SHAPES.RECTANGLE) {
            txtFieldParameterOne.setOpacity(1);
            txtFieldParameterTwo.setOpacity(1);
        } else if (group.getSelectedToggle().getUserData() == ShapeFacade.SHAPES.CIRCLE ||
                group.getSelectedToggle().getUserData() == ShapeFacade.SHAPES.SQUERE) {
            txtFieldParameterOne.setOpacity(1);
            txtFieldParameterTwo.setOpacity(0);
        }     
        
    }
    
}
