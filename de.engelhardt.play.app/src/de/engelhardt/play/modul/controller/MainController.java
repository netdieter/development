/**
 * Sample Skeleton for 'Main.fxml' Controller Class
 */

package de.engelhardt.play.modul.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {
	
	@Inject
	@Log
	private Logger logger;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnDialog"
    private Button btnDialog; // Value injected by FXMLLoader

    @FXML
    void handleDialog(ActionEvent event) {
    	logger.debug("handleDialog");
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnDialog != null : "fx:id=\"btnDialog\" was not injected: check your FXML file 'Main.fxml'.";

    }
}
