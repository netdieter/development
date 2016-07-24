
package de.engelhardt.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javafx.scene.layout.BorderPane;

public class Main {
	@Inject
	public Main() {

	}

	@PostConstruct
	public void postConstruct(BorderPane  parent) {

	}

}