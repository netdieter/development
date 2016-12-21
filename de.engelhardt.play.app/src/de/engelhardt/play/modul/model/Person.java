/**
 * 
 */
package de.engelhardt.play.modul.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dieter
 *
 */
public class Person {
	private StringProperty name;
	private StringProperty vorname;
	private StringProperty email;

    public Person(String fName, String lName, String email) {
        this.name = new SimpleStringProperty(fName);
        this.vorname = new SimpleStringProperty(lName);
        this.email = new SimpleStringProperty(email);
    }
	
	public final StringProperty nameProperty() {
		return this.name;
	}
	
	public final String getName() {
		return this.nameProperty().get();
	}
	
	public final void setName(final String name) {
		this.nameProperty().set(name);
	}
	
	public final StringProperty vornameProperty() {
		return this.vorname;
	}
	
	public final String getVorname() {
		return this.vornameProperty().get();
	}
	
	public final void setVorname(final String vorname) {
		this.vornameProperty().set(vorname);
	}

	public final StringProperty emailProperty() {
		return this.email;
	}
	

	public final String getEmail() {
		return this.emailProperty().get();
	}
	

	public final void setEmail(final String email) {
		this.emailProperty().set(email);
	}
	
	
	
}
