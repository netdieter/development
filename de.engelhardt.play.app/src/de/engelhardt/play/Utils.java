/**
 * 
 */
package de.engelhardt.play;

import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.ValidationSupport;

import javafx.scene.control.Alert;

/**
 * @author dieter
 *
 */
public class Utils {

	public static void showValidationError(ValidationSupport valSup) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText("Validation Error");
		alert.setContentText(getString(valSup.getValidationResult()));
		alert.showAndWait();
	}
	
	public static void showMessage(String msg) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText("Information");
		alert.setContentText(msg);
		alert.showAndWait();
	}
	private static String getString(ValidationResult valRes){
		StringBuffer sb = new StringBuffer();
		valRes.getMessages().forEach(s -> {sb.append(s);sb.append("\n");});
		return sb.toString();
	}
}

