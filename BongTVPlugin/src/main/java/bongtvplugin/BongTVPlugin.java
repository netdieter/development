package bongtvplugin;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Logger;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import tvbrowser.extras.common.ConfigurationHandler;
import util.exc.ErrorHandler;
import devplugin.ActionMenu;
import devplugin.Date;
import devplugin.Plugin;
import devplugin.PluginInfo;
import devplugin.Program;
import devplugin.SettingsTab;
import devplugin.ThemeIcon;
import devplugin.Version;

/**
 * 
 * @author Dieter
 *
 */
public class BongTVPlugin extends Plugin {
	private static final Logger mLog = Logger.getLogger(BongTVPlugin.class.getName());
	
	private static Version version = new  Version (1, 5, false);
	private static BongTVPlugin mInstance;
	protected static final util.ui.Localizer mLocalizer = util.ui.Localizer	.getLocalizerFor(BongTVPlugin.class);
	private static BongTVData mBongTVData = new BongTVData();
	
	private static BongTVChannelMap channelMap = new BongTVChannelMap();
	
	public BongTVPlugin() {
		mInstance = this;
	}

	
	public static synchronized BongTVPlugin getInstance() {
		if (mInstance == null) {
			new BongTVPlugin();
		}
		return mInstance;
	}
	
	public static Version getVersion(){
		return version;
	}

	@Override
	public PluginInfo getInfo() {
	    // TODO NLS
		PluginInfo pin = new PluginInfo(BongTVPlugin.class, "BongTV-Plugin", "Dieses Plugin verbindet TVBrowser mit Bong.tv", "engelhardt@ew6.org");
		return pin;
	}

	@Override
	public SettingsTab getSettingsTab() {
		return new BongSettingsTab();
	}

	@Override
	public ActionMenu getContextMenuActions(final Program program) {
		// Eine Aktion erzeugen, die die Methode sendMail(Program) aufruft, sobald sie aktiviert wird.
		final AbstractAction action = new AbstractAction() {
		    public void actionPerformed(ActionEvent evt) {
		    	String title = program.getTitle();
		    	Date date = program.getDate();
		    	String startTime = program.getTimeString();
		    	String cannelId = program.getChannel().getUniqueId();
		    	if(channelMap.containsKey(cannelId)){
		    		int cannel = channelMap.get(cannelId);
		    		BongTVService.setBonguser(mBongTVData);
		    		if(BongTVService.getInstance().recordProgram(title, date.getFormattedString("dd-MM-yyyy"), startTime, cannel)){
		    			program.mark(BongTVPlugin.getInstance());
		    			program.validateMarking();
		    		} else {
		    		    // TODO NLS
		    			String sMsg = "Das Programm konnte nicht gefunden werden.\n" +
		    					"Evl. wird das Programm auf Bong.tv unter einen abweichenden Namen geführt.\n" +
		    					"Zur Programmierung sollten sie Bong.tv direkt verwenden.";
		    			JOptionPane.showMessageDialog(getParentFrame(), sMsg);
		    		}
		    	}
		    }
		  };
		  
		  // Enable menue only for channels provided by Bong.tv and User is validated
		  if( !mBongTVData.isValid() ||
		      program == null || 
			  program.getChannel() == null || 
			  program.getChannel().getName().equals("Channel 1") ||
			  !channelMap.containsKey(program.getChannel().getUniqueId())){
			  action.setEnabled(false);
		  }
		  // Der Aktion einen Namen geben. Dieser Name wird dann im Kontextmenü gezeigt
		  // TODO NLS
		  action.putValue(Action.NAME, "Bong.tv Aufnahme");

		  // Der Aktion ein Icon geben. Dieses Icon wird mit dem Namen im Kontextmenü gezeigt
		  // Das Icon sollte 16x16 Pixel groß sein
		  action.putValue(Action.SMALL_ICON, new ImageIcon(
				  getClass().getResource("icons/16x16/default/Icon-BONGTV.png")));

		  // Das Aktions-Menü erzeugen und zurückgeben
		  return new ActionMenu(action); 	
	}

	
	@Override
	public ThemeIcon getMarkIconFromTheme() {
		// Hier ohne Endung!!!
		return new ThemeIcon("default", "mix_record", 16);
	}

	
	public static BongTVData getBongTVData() {
		return mBongTVData;
	}

	public static void setBongTVData(BongTVData mBongTVData) {
		BongTVPlugin.mBongTVData = mBongTVData;
	}


	@Override
	public void readData(ObjectInputStream in) throws IOException, ClassNotFoundException {
		mBongTVData = (BongTVData) in.readObject();
		if (mBongTVData == null){
			mBongTVData = new BongTVData();
		}
	}


	@Override
	public void writeData(ObjectOutputStream out) throws IOException {
		mLog.entering("BongTVPlugin", "writeData()");
		BongTVService bos = BongTVService.getInstance();
		String uid = bos.checkUser(mBongTVData.getUser(), mBongTVData.getPassword());
		if(uid != null) {
			mBongTVData.setUID(uid);
			mBongTVData.setValid(true);
		}
		else {
		    // TODO NLS
			ErrorHandler.handle(mLocalizer.msg("invalidBongTVUser",
					"BongTV-Benutzer / Passwort nicht erkannt"), null);
		}
		out.writeObject(mBongTVData);
	}

	public void save(){
		saveMe();
	}
}
