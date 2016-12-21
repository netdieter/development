package de.engelhardt.play.modul.controller;

import java.util.concurrent.TimeUnit;

import org.controlsfx.dialog.ProgressDialog;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import de.engelhardt.play.BIND;
import de.engelhardt.play.modul.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TestController {
	
	final ObservableList<Person> data = FXCollections.observableArrayList(
		new Person("Jacob", "Smith", "jacob.smith@example.com"),
		new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
		new Person("Ethan", "Williams", "ethan.williams@example.com"),
		new Person("Emma", "Jones", "emma.jones@example.com"),
		new Person("Michael", "Brown", "michael.brown@example.com")
	);
    
	@FXML
    private TableView<Person> tabTest;

    @FXML
    private TableColumn<Person, String> colName;

    @FXML
    private TableColumn<Person, String> colVorname;
    
    @FXML
    private TableColumn<Person, String> colEmail;

	
	@FXML
	private Button btnTest;
	
	@FXML
	@BIND(value = "testval", struct = "")
	private TextField txtTest;
	 @FXML
    private DatePicker dtDate;

	

	
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
		populateTable();
		valSup = new ValidationSupport();
		valSup.initInitialDecoration();
		valSup.registerValidator(txtTest, true , Validator.createEmptyValidator("Test sollte nicht leer sein!"));
// TODO ValidationSupport dahingehend testen ob invalid / invisible GUI Elemente von ChangeEvent getriggert wird.
		
//		valSup.registerValidator(dtDate, false , Validator.combine(validators));
	}
	
	private void populateTable(){
		colVorname.setCellValueFactory(data -> data.getValue().vornameProperty());
		colName.setCellValueFactory(data -> data.getValue().nameProperty());
		colEmail.setCellValueFactory(data -> data.getValue().emailProperty());
		tabTest.setItems(data);
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
