package bongtvplugin;

import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import util.ui.EnhancedPanelBuilder;

import com.jgoodies.forms.layout.CellConstraints;

import devplugin.SettingsTab;

public class BongSettingsTab implements SettingsTab{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField tfBenutzer = new JTextField();
	private static JPasswordField tfPasswort = new JPasswordField();
	private static JCheckBox cbProgrammeUebernehmen = new JCheckBox("Programme übernehmen?") ;

	
	public BongSettingsTab(){
		BongTVPlugin.getInstance();
		tfBenutzer.setText(BongTVPlugin.getBongTVData().getUser());
		tfPasswort.setText(BongTVPlugin.getBongTVData().getPassword());
	}
	
	@Override
	public JPanel createSettingsPanel() {
		EnhancedPanelBuilder pb = new EnhancedPanelBuilder("pref, 3dlu, 0dlu:grow");
	    pb.setDefaultDialogBorder();
	    CellConstraints cc1 = new CellConstraints();
	    CellConstraints cc2 = new CellConstraints();
	    // TODO NLS
	    pb.addParagraph("Bong.tv Zugangsdaten");
	    pb.addRow();
	    // TODO NLS
		pb.add(new JLabel("Benutzer: "), cc1.xy(1, pb.getRowCount()), 
				tfBenutzer, cc2.xy(3, pb.getRowCount()));
	    pb.addRow();
	    // TODO NLS
		pb.add(new JLabel("Passwort: "), cc1.xy(1, pb.getRowCount()), 
				tfPasswort, cc2.xy(3, pb.getRowCount()));
		//pb.nextLine();
		// TODO NLS
		//pb.addSeparator("Von Bong.tv unterstützte Programme in Programmübersicht übernehmen?");
		//pb.nextLine();
		//pb.add(cbProgrammeUebernehmen);
		return pb.getPanel();
	}

	@Override
	public void saveSettings() {
		BongTVPlugin.getBongTVData().setUser(tfBenutzer.getText());
		BongTVPlugin.getBongTVData().setPassword(tfPasswort.getText());
		BongTVPlugin.getInstance().save();
	}

	
	@Override
	public Icon getIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
	    // TODO NLS
		return "Bong.tv Settings";
	}

	
}
