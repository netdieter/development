 
package de.engelhardt.play.handler;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;

public class SwitchDefaultPerspective {
	@Inject
	@Log
	private Logger log;

	@Execute
	public void execute(EPartService partServive) {
		log.debug("Switch to default perspective");
		partServive.switchPerspective("de.engelhardt.play.app.perspective.defaultperspektive");

	}
		
}