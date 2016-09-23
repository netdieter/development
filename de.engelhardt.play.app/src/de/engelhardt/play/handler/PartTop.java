 
package de.engelhardt.play.handler;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.fx.core.di.LocalInstance;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerCreator;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class PartTop {
	private static Logger logger = LoggerCreator.createLogger(PartTop.class);
	
	@Inject
	public PartTop() {
		
	}
	
	@PostConstruct
	public void postConstruct(BorderPane parent, @LocalInstance FXMLLoader loader) {
		loader.setLocation(getClass().getResource("/resources/fxml/modul/Test.fxml"));
		logger.debug("NaviPart");
		try {
			parent.setCenter(loader.load());
		} catch (IOException e) {
			logger.error(e.getCause().getMessage());
			e.printStackTrace();
		}
	}
}