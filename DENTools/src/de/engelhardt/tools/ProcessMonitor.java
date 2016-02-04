/**
 * 
 */
package de.engelhardt.tools;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 * @author dieter
 *
 */
public class ProcessMonitor {

	public static void main(String[] args) {
		JFrame meinJFrame = new JFrame();
		meinJFrame.setSize(300, 100);
		meinJFrame.setTitle("JProgressBar Beispiel");
		JPanel meinPanel = new JPanel();
 
		// JProgressBar-Objekt wird erzeugt
		JProgressBar meinLadebalken = new JProgressBar(0, 100);
 
		// Wert für den Ladebalken wird gesetzt
		meinLadebalken.setValue(0);
 
		// Der aktuelle Wert wird als 
		// Text in Prozent angezeigt
		meinLadebalken.setStringPainted(true);
 
		// JProgressBar wird Panel hinzugefügt
		meinPanel.add(meinLadebalken);
 
		meinJFrame.add(meinPanel);
		meinJFrame.setVisible(true);
 
		// Wert des Ladebalkens wird in der Schleife
		// bei jedem Durchgang um 1 erhöht bis der
		// maximale Wert erreicht ist
		for(int i=0; i<=meinLadebalken.getMaximum(); i++){
			meinLadebalken.setValue(i);
			try {
				// aktueller Thread pausiert  
				// für 50 Millisekunden
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
 		}
 	}
}
