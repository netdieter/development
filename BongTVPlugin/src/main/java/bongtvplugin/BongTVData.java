/**
 * 
 */
package bongtvplugin;

import java.io.Serializable;

/**
 * @author Dieter
 *
 */
public class BongTVData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5537419431134804099L;
	private String User;
	private String Password;
	private String UID;
	private boolean isValid = false;
	
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}
