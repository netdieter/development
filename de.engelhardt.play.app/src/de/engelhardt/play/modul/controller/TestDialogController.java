/**
 * Sample Skeleton for 'TestDialog.fxml' Controller Class
 */

package de.engelhardt.play.modul.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class TestDialogController {

	  @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="btnTest"
	    private Button btnTest; // Value injected by FXMLLoader

	    @FXML // fx:id="txtTest"
	    private TextField txtTest; // Value injected by FXMLLoader

	    @FXML // fx:id="dtDate"
	    private DatePicker dtDate; // Value injected by FXMLLoader

	    @FXML
	    void onTest(ActionEvent event) {

	    }

	    @FXML // This method is called by the FXMLLoader when initialization is complete
	    void initialize() {
	        assert btnTest != null : "fx:id=\"btnTest\" was not injected: check your FXML file 'Test.fxml'.";
	        assert txtTest != null : "fx:id=\"txtTest\" was not injected: check your FXML file 'Test.fxml'.";
	        assert dtDate != null : "fx:id=\"dtDate\" was not injected: check your FXML file 'Test.fxml'.";

	    }}
