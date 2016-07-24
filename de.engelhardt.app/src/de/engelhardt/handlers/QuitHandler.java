 
package de.engelhardt.handlers;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.workbench.IWorkbench;

@SuppressWarnings("restriction")
public class QuitHandler {
	@Inject 
	Logger logger;
	
	@Execute
	public void execute(IWorkbench workbench) {
		logger.debug("und Tschüß");
		workbench.close();
	}
}