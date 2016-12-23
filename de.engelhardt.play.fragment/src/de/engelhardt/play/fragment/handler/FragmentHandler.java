 
package de.engelhardt.play.fragment.handler;

import org.eclipse.e4.core.di.annotations.Execute;

public class FragmentHandler {
	@Execute
	public void execute() {
		System.out.println("Menue Fragment ausgelöst");
	}
	
		
}