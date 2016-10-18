package de.engelhardt.play.modul.controller;

import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import de.engelhardt.play.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TestController {
	
	private static String validStmt = "Dieter";
	
	@FXML
	private Button btnTest;
	@FXML
	private TextField txtTest;

	
	ValidationSupport valSup;
	@FXML
    void onTest(ActionEvent event) {
		if(valSup.isInvalid()){
			Utils.showValidationError(valSup);
		} else {
			Utils.showMessage("Alles Ok");
		}
    }

	@FXML
	void initialize() {
		valSup = new ValidationSupport();
		valSup.initInitialDecoration();
		valSup.registerValidator(txtTest, true , Validator.createEmptyValidator("Test sollte nicht leer sein!"));		
	}
}