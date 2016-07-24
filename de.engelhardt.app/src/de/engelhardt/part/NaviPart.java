
package de.engelhardt.part;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.eclipse.fx.core.di.LocalInstance;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerCreator;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class NaviPart {
	private static Logger LOGGER = LoggerCreator.createLogger(NaviPart.class);

	@PostConstruct
	public void postConstruct(BorderPane parent, @LocalInstance FXMLLoader loader) {
		loader.setLocation(getClass().getResource("/de/engelhardt/app/controller/Navi.fxml"));
		LOGGER.debug("NaviPart");
		try {
			parent.setCenter(loader.load());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}