 
package de.engelhardt.play.fragment.handlere;

import org.eclipse.e4.core.di.annotations.Execute;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FragmentHandler {
	@Execute
	public void execute() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Fragment-Menue");
		alert.setHeaderText("Info");
		alert.showAndWait();
	}
		
}