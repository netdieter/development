 
package de.engelhardt.play.modul.handler;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.fx.core.di.LocalInstance;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class MainHandler {

	@Inject
	@Log
	private Logger logger;

	@Inject
	public MainHandler() {
		
	}
	
	@PostConstruct
	public void postConstruct(BorderPane parent, @LocalInstance FXMLLoader loader) {
		logger.debug("MainHandler");
		loader.setLocation(getClass().getResource("/fxml/modul/Main.fxml"));
		try {
			parent.setCenter(loader.load());
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
	}
	
	
	
	
}