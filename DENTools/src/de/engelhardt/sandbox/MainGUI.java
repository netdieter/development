/**
 * 
 */
package de.engelhardt.sandbox;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.beans.BeanAdapter;
import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.forms.builder.FormBuilder;

import de.engelhardt.binding.ComboBoxListObject;
import de.engelhardt.binding.TestBean;
import de.engelhardt.tools.TextAreaOutputStream;

/**
 * @author dieter
 *
 */
public class MainGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea textArea = new JTextArea(15, 30);
	private TextAreaOutputStream taOutputStream = new TextAreaOutputStream(textArea, "Out");
	private JScrollPane jsptest =  new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private JButton btnSetValue = new JButton("Set");
	private JLabel lblAnzeige = new JLabel("-Test-");

	private TestBean testBean = new TestBean();
	private BeanAdapter<TestBean> beanAdapter = new BeanAdapter<TestBean>(testBean, true);
	private ValueModel selectionHolder = beanAdapter.getValueModel("cbobj");
	private ValueModel indexHolder = beanAdapter.getValueModel("id");
	private Integer testId = new Integer(1);
	
	public static void main(String[] args) {
				new MainGUI();
	}

	public MainGUI() throws HeadlessException {
		super();
		setTitle("Meine Spielwiese für diverse Experimente");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setJMenuBar(buildMenuBar());
		setContentPane(buildStartupContent());
		initComponents();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		System.setOut(new PrintStream(taOutputStream));
		pack();
		setVisible(true);
		System.out.println("Hier gehts los");
//		LongExecutionTask let = new LongExecutionTask();
//		let.run();
	}

	private void initComponents(){
		btnSetValue.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				testId = (testId ++)%6;
				testBean.setId(testId);
//				testBean.setCbobj(new ComboBoxListObject(3, "Das dritte Element"));
			}
			
		});
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
	
	private JPanel buildStartupContent() {
	      return FormBuilder.create()
	    		  .columns("left:90dlu, 3dlu, 200dlu")
	    		  .rows("p, 3dlu, p, 3dlu, p")
	    		  .addLabel("Soderla").xy(3, 1)
	    		  .add(jsptest).xyw(1,  3, 3)
	    		  .add(buildComboBoxPanel()).xyw(1, 5, 3)
	    		  .build();
	}
	
	private JPanel buildComboBoxPanel(){
		return FormBuilder.create()
				.columns("fill:100dlu, 3dlu, pref, 3dlu, left:pref")
				.rows("pref")
				.add(createJComboBox()).xy(1, 1)
				.add(btnSetValue).xy(3, 1)
				.add(lblAnzeige).xy(5, 1)
				.build();
		
	}
	
	private JComboBox<ComboBoxListObject> createJComboBox() {
		ArrayList<ComboBoxListObject> list = new ArrayList<ComboBoxListObject>();
		list.add(new ComboBoxListObject(1, "Das erste Element"));
		list.add(new ComboBoxListObject(2, "Das zweite Element"));
		list.add(new ComboBoxListObject(3, "Das dritte Element"));
		list.add(new ComboBoxListObject(4, "Das vierte Element"));
		list.add(new ComboBoxListObject(5, "Das fünfte Element"));
		SelectionInList<ComboBoxListObject> selli = new SelectionInList<ComboBoxListObject>(list, selectionHolder, indexHolder);
		JComboBox<ComboBoxListObject> box = BasicComponentFactory.createComboBox(selli);
		
		box.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				lblAnzeige.setText(testBean.getCbobj().toString());
			}
		});

		//		box.setModel(new DefaultComboBoxModel(list.toArray()));
		return box;
	}
}
