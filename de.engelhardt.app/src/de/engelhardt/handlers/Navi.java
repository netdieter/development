 
package de.engelhardt.handlers;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.log.Logger;

public class Navi {
	@Inject 
	Logger logger;
	
	@Execute
	public void execute() {
		logger.debug("Navi -> Execute");
	}
		
}