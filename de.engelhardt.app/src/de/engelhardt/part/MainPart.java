
package de.engelhardt.part;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.fx.core.di.LocalInstance;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerCreator;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class MainPart {
	@Inject
	public MainPart() {

	}

	private static Logger logger = LoggerCreator.createLogger(MainPart.class);

	@PostConstruct
	public void postConstruct(BorderPane parent, @LocalInstance FXMLLoader loader) {
		loader.setLocation(getClass().getResource("/de/engelhardt/app/controller/Main.fxml"));
		logger.debug("NaviPart");
		try {
			parent.setCenter(loader.load());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}