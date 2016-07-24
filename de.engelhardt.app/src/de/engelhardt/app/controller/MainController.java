package de.engelhardt.app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.eclipse.e4.core.di.extensions.Preference;

import de.engelhardt.utils.PropertiesManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class MainController implements Initializable {
	@FXML
	private TextField prefvalue;

//	@Inject
//	@Preference("test")
//	String pref;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		String pref = PropertiesManager.getInstance().getPropertie("test");
		prefvalue.setText(pref);
		
	}

}
