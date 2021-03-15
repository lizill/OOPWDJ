package codingwithscpark_ch12;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONpasing {
	
	public String getString(String str) {
		PapagoAPI ppA = new PapagoAPI();
		String jsonData = ppA.getText(str).toString();
		
		try {
			JSONParser jsonParse = new JSONParser();

			JSONObject jsonObj = (JSONObject) jsonParse.parse(jsonData);
			JSONObject messageObj = (JSONObject) jsonObj.get("message");
			JSONObject resultObj = (JSONObject) messageObj.get("result");
			
			return resultObj.get("translatedText").toString();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "";
	}
}