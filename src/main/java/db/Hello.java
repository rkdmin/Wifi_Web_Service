package db;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Hello {

	public static void main(String[] args) throws IOException {
	
		try {
			BufferedReader br = null;
			String wifiURL = "http://openapi.seoul.go.kr:8088/436e476571323272323446796c516e/json/TbPublicWifiInfo/1/5/";
			URL url = new URL(wifiURL);
			
			// openConnection메소드 이용
			HttpURLConnection urlCon = (HttpURLConnection)url.openConnection();
			urlCon.setRequestMethod("GET");
			urlCon.setRequestProperty("Content-type", "application/json");
			System.out.println("Responce Code:" + urlCon.getResponseCode());
		
			urlCon.setDoOutput(true); //OutputStream을 사용해서 post body 데이터 전송
			String request_data;
			try (OutputStream os = urlCon.getOutputStream()){
				System.out.println(os.toString());
			}
			catch(Exception e) {
				e.printStackTrace();
			}		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
