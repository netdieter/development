package de.engelhardt.app.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.Accordion;

import java.net.URL;
import java.util.ResourceBundle;

import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerCreator;

import de.engelhardt.part.NaviPart;
import javafx.event.ActionEvent;

import javafx.scene.control.TitledPane;

public class NaviController implements Initializable{

	private static Logger logger = LoggerCreator.createLogger(NaviPart.class);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		logger.debug("NaviController");

	}

	@FXML
	private Accordion accordion;
	@FXML
	private TitledPane test1;
	@FXML
	private Button button1;
	@FXML
	private Button button2;
	@FXML
	private TitledPane test2;

	// Event Listener on Button[#button1].onAction
	@FXML
	public void action1(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#button2].onAction
	@FXML
	public void action2(ActionEvent event) {
		// TODO Autogenerated
	}
}
