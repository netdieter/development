 
package de.engelhardt.play.modul.handler;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;

public class TestDialogHandler {
	@Inject
	@Log
	private Logger logger;

	@Execute
	public void execute() {
		logger.debug("TestDialogHandler");
	}
		
}