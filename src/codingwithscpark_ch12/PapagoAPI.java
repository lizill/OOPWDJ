package codingwithscpark_ch12;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
public class PapagoAPI {
	
	private StringBuffer response = new StringBuffer();
    private String str;
	
	public StringBuffer getText() {
		String clientId = "4ekcJpW2NjSUw6NVzDv9";
	    String clientSecret = "wgeNdCppaU";
	    try {
	        String text = URLEncoder.encode(str, "UTF-8");
	        String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
	        URL url = new URL(apiURL);
	        HttpURLConnection con = (HttpURLConnection)url.openConnection();
	        con.setRequestMethod("POST");
	        con.setRequestProperty("X-Naver-Client-Id", clientId);
	        con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	        // post request
	        String postParams = "source=ko&target=en&text=" + text;
	        con.setDoOutput(true);
	        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	        wr.writeBytes(postParams);
	        wr.flush();
	        wr.close();
	        int responseCode = con.getResponseCode();
	        BufferedReader br;
	        if(responseCode==200) { // 정상 호출
	            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        } else {  // 에러 발생
	            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	        }
	        String inputLine;
	        
	        while ((inputLine = br.readLine()) != null) {
	            response.append(inputLine);
	        }
	        br.close();
	        response.delete(0, response.indexOf("translatedText")+17);
	        response.delete(response.indexOf(",\"engineType\":")-1, response.length());
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    
		return response;
	}
	
	public void setText(String text) {
		this.str = text;
	}
}