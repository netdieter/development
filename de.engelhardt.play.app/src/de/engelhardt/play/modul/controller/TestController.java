package de.engelhardt.play.modul.controller;

import java.util.concurrent.TimeUnit;

import org.controlsfx.dialog.ProgressDialog;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TestController {
	
	
	@FXML
	private Button btnTest;
	@FXML
	private TextField txtTest;

	
	ValidationSupport valSup;
	@FXML
    void onTest(ActionEvent event) {
//		if(valSup.isInvalid()){
//			Utils.showValidationError(valSup);
//		} else {
//			Utils.showMessage("Alles Ok");
//		}
		LongRunnigTask lrtservice = new LongRunnigTask(); 
		ProgressDialog dlg = new ProgressDialog(lrtservice);
		dlg.setTitle("Haalooooo");
		dlg.setHeaderText("Bitte warten");
		dlg.setContentText("Auftrag läuft");
		new Thread(lrtservice).start();
		
    }

	@FXML
	void initialize() {
		valSup = new ValidationSupport();
		valSup.initInitialDecoration();
		valSup.registerValidator(txtTest, true , Validator.createEmptyValidator("Test sollte nicht leer sein!"));		
	}
	
	class LongRunnigTask extends Task<Void>{

		@Override
		protected Void call() throws Exception {
			for(int i = 0; i < 10; i++){
				 try {
					TimeUnit.SECONDS.sleep(1);
					updateProgress(i, 10);
					updateMessage("wir sind bei " + i );
//					this.set
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
		
	}
}
