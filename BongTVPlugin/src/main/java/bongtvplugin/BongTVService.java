/**
 * 
 */
package bongtvplugin;

import java.io.StringReader;
import java.net.URI;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import util.exc.ErrorHandler;

/**
 * Kommunikations mit bong.tv
 * @author Dieter
 *
 */
public class BongTVService {

	private static BongTVService service;
	DefaultHttpClient httpclient;
	private static BongTVData bonguser;
	
	public static BongTVData getBonguser() {
		return bonguser;
	}

	public static void setBonguser(BongTVData bonguser) {
		BongTVService.bonguser = bonguser;
	}

	private BongTVService(){
		service = this;
		httpclient = new DefaultHttpClient();
	}
	
	public static synchronized BongTVService getInstance() {
		if (service == null) {
			new BongTVService();
		}
		return service;
	}
	
	/**
	 * Prüft ob das Login bei Bong.tv bekannt ist.
	 * @param user
	 * @param password
	 * @return Die Benutzerkennung (UID) wenn das Login gültig ist. Sonst null
	 */
	public String checkUser(String user, String password){
		try {
			String http = "http://www.bong.tv/api/users.xml?username=" +
				user + 
				"&password=" +
				password;
			HttpGet httpget = new HttpGet(http);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			String strResponse = httpclient.execute(httpget, responseHandler);
			Document xmlresponce = loadXMLFromString(strResponse);
			String strStatus = xmlresponce.getElementsByTagName("status")
					.item(0).getFirstChild().getNodeValue();
			if(strStatus.equals("true"))
				return xmlresponce.getElementsByTagName("unique_id")
						.item(0).getFirstChild().getNodeValue();
			return null;
		}
		catch (Exception e){
			ErrorHandler.handle("Beim prüfen desn Bong-Benutzers ist ein Fehler aufgetreten", e);			
			return null;
		}
	}

	/**
	 * Programm aufnehmen
	 * @param title
	 * @param date
	 * @param start
	 * @param cannel
	 */
	public boolean recordProgram(String title, String date, String start, int cannel){
		String prog_id = findProgrammId(title, date, start, cannel);
		if(prog_id != null){
			registerRecordJob(prog_id);
			return true;
		}
		return false;
	}
	
	/**
	 * Konvertiert String in ein DOM-Dokument
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	private static Document loadXMLFromString(String xml) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }
	
	/**
	 * Ermittelt die Bong-ID der Sendung
	 * @param title
	 * @param date
	 * @param cannel
	 * @return
	 */
	private String findProgrammId(String title, String date, String start, int cannel){
		Long progID = null;
		JSONParser parser;
		JSONArray jsonArray; 
		
		try {
//			URI  uri = new URI("http://www.bong.tv/service/broadcasts/search," +
//					"q=" + title,
//					"date=" + date,
//					"channel=" + cannel);
//			HttpGet httpget = new HttpGet(uri);
			String http = "http://www.bong.tv/service/broadcasts/search?q=" +
					URLEncoder.encode(title, "ISO-8859-1") + 
					"&date=" + date +
					"&channel=" + cannel;
			URI  uri = new URI(http);
			HttpGet httpget = new HttpGet(uri);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			String strResponse = httpclient.execute(httpget, responseHandler);
			parser = new JSONParser();
			jsonArray = (JSONArray)parser.parse(strResponse);
			// Bei Mehrfachauswahl wird per start Time die richtige ID gesucht
			for(Object jobj :jsonArray){
				JSONObject job = (JSONObject)jobj;
				if(((String)job.get("start_time")).equals(start))
					progID = (Long)job.get("id");
			}
			if(progID != null)
				return progID.toString();
			else
				return null;
		} catch (Exception e){
			ErrorHandler.handle("Beim ermitteln der Bong-Programm-ID ist ein Fehler aufgetreten", e);			
			return null;
		}
	}
	
	/**
	 * Meldet eine Sendung zur Aufnahme an
	 * @param prog_id
	 */
	private void registerRecordJob(String prog_id){
//		http://www.bong.tv/api/recordings.xml?broadcast_id=IDOFBROADCAST&username=
//			USERNAME&password=PASSWORD
		try {
			String http = "http://www.bong.tv/api/recordings.xml?broadcast_id=" +
					prog_id + 
					"&username=" + bonguser.getUser() +
					"&password=" + bonguser.getPassword();
			//System.out.println("Post: " + http);
			HttpPost httppost = new HttpPost(http);
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			//System.out.println("Post response: " + response.getStatusLine());
	        if (entity != null) {
	        	EntityUtils.consume(entity);
	        }
		} catch (Exception e){
			ErrorHandler.handle("Beim senden des Bong-Programm-Record-Auftrags ist ein Fehler aufgetreten", e);			
		}
	
	}
}