/**
 * Sample Skeleton for 'TestDialog.fxml' Controller Class
 */

package de.engelhardt.play.modul.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.CustomTextField;

import javafx.fxml.FXML;

public class TestDialogController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="textFieldCustom"
    private CustomTextField textFieldCustom; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert textFieldCustom != null : "fx:id=\"textFieldCustom\" was not injected: check your FXML file 'TestDialog.fxml'.";

    }
}
