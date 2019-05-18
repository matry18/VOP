/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_02_Search_And_Replace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 *
 * @author aalsc
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txtFieldSearch;
    @FXML
    private TextField txtFieldReplace;
    @FXML
    private TextArea txtArea;
    @FXML
    private Button btnReplaceAll;
    @FXML
    private Button btnOpenFile;
    @FXML
    private Button btnSaveAs;

    private File InitialDirectory;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        InitialDirectory = new File("."); //Initial Directory peger på projektmappen med en ny fil

    }

    @FXML
    private void handleReplaceAllButtonAction(ActionEvent event) {
        txtArea.setText(Facade.SearchAndReplace(txtFieldSearch.getText(), txtFieldReplace.getText(), txtArea.getText()));
    }

    @FXML
    private void handlebtnOpenFileButtonAction(ActionEvent event) {
        FileChooser fc = new FileChooser(); //opretter en variabel af FileChooser
        fc.setInitialDirectory(InitialDirectory);
        File fileIn = fc.showOpenDialog(null);
        StringBuilder sb = new StringBuilder();

        try (Scanner sc = new Scanner(fileIn)) {

            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
                sb.append("\n");

            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        txtArea.setText(sb.toString());
    }

    @FXML
    private void handlebtnSaveAsButtonAction(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setInitialFileName("HelloMoon.txt");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT - Text File (.txt)", "*.txt"),
                new FileChooser.ExtensionFilter("CSV - Comma Seperated File (.csv)", "*.csv"));
        fc.setSelectedExtensionFilter(null);
        fc.setInitialDirectory(InitialDirectory);
        File fileOut = fc.showSaveDialog(null);
        try (PrintWriter pw = new PrintWriter(fileOut)) {
            pw.print(txtArea.getText());
        } catch (FileNotFoundException ex) {
            System.out.println("Can not save file!");
        }

    }

}
