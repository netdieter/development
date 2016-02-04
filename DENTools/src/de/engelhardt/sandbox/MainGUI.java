/**
 * 
 */
package de.engelhardt.sandbox;

import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import com.jgoodies.forms.builder.FormBuilder;

import de.engelhardt.tools.TextAreaOutputStream;

/**
 * @author dieter
 *
 */
public class MainGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea textArea = new JTextArea(15, 30);
	private TextAreaOutputStream taOutputStream = new TextAreaOutputStream(textArea, "Out");
	private JScrollPane jsptest =  new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
	           JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


	public static void main(String[] args) {
				new MainGUI();
	}

	public MainGUI() throws HeadlessException {
		super();
		this.setTitle("Meine Spielwiese für diverse Experimente");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setJMenuBar(buildMenuBar());
		this.setContentPane(buildStartupContent());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		System.setOut(new PrintStream(taOutputStream));
		this.pack();
		this.setVisible(true);
		System.out.println("Hier gehts los");
		LongExecutionTask let = new LongExecutionTask();
		let.run();
	}

	private JMenuBar buildMenuBar() {
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;

		// Create the menu bar.
		menuBar = new JMenuBar();

		// Build the first menu.
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu);

		// a group of JMenuItems
		menuItem = new JMenuItem("Reserviert ", KeyEvent.VK_T);
		// menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		menu.add(menuItem);

		// a submenu
		menu.addSeparator();
		submenu = new JMenu("A submenu");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("An item in the submenu");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem = new JMenuItem("Another item");
		submenu.add(menuItem);
		menu.add(submenu);

		// Build second menu in the menu bar.
		menu = new JMenu("Zukünftige Experimente");
		menu.setMnemonic(KeyEvent.VK_N);
		menu.getAccessibleContext().setAccessibleDescription("Bis jetzt noch nichts implementiert");
		menuBar.add(menu);

		return menuBar;
	}
	
	private Container buildStartupContent() {
	      return FormBuilder.create()
	    		  .columns("left:90dlu, 3dlu, 200dlu")
	    		  .rows("p, 3dlu, p, 3dlu")
	    		  .addLabel("Soderla").xy(3, 1)
	    		  .add(jsptest).xyw(1,  3, 3)
	    		  .build();
	}

}
