/**
 * 
 */
package de.engelhardt.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author dieter
 *
 */
public class PropertiesManager {
	Properties prop = null;

	private static PropertiesManager instance;
	
	private PropertiesManager() {
	}

	public static PropertiesManager getInstance(){
		if(instance == null){
			instance  = new PropertiesManager();
		}
		return instance;
	}
	
	private void Init(){
		try {
			InputStream is = getClass().getClassLoader().getResourceAsStream("../config/engelhardt.properties");
			prop = new Properties();
			prop.load(is);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	
	public String getPropertie(String property){
		if(prop == null){
			Init();
		}
		return prop.getProperty(property);
	}
}
