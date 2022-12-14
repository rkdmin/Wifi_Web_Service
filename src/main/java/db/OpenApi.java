package DB;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class OpenApi {
	public static int openWifiApi(int from, int to) {
		try{            
        	// 1 ~ 1000 까지의 서울시 와이파이 URL (json)
			StringBuffer wifiURL = new StringBuffer();
			wifiURL.append("http://openapi.seoul.go.kr:8088/436e476571323272323446796c516e/json/TbPublicWifiInfo");
			wifiURL.append("/").append(from).append("/").append(to).append("/");  
            
            // 1. URL 생성자로 URL 객체 만들기 
            URL url = new URL(wifiURL.toString());
            
            // 2. HTTP Connection구하기 (웹을 통해 데이터를 주고 받음)
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            // 3. Request 방식 설정
            conn.setRequestMethod("GET");
            
            // 4. Request 속성 값 설정 (JSON 형식의 데이터를 받음)
            conn.setRequestProperty("Content-type", "application/json");
            
            // 5. 출력 가능 상태로 설정
            conn.setDoOutput(true);
            
            // 6. 데이터 읽기
            StringBuffer sb = new StringBuffer();
        	BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        	while(br.ready()) {
        		sb.append(br.readLine());
        	}
        	
        	//8.다 읽어들인 파일의 내용을 String 객체에 전달.
            String jsonString = sb.toString();//요 jsonString만 다른객체로 넘겨주면 됨.
            // System.out.println(jsonString);
            
            //Json을 파싱하는 객체소속
            //9.Gson객체 선언.
            Gson gson = new Gson();
          
            //10.Gson의 fromJson 메소드를 사용하여 Root클래스에 json의 내용들을 저장.
            Root root = gson.fromJson(jsonString,Root.class);
            
            //11. 결과 확인
            // 오류확인2 아예 from부터 데이터가 없으면 위의 fromJson이 안된다.
            if(root == null) {
            	return root.TbPublicWifiInfo.list_total_count;
            }
            
            // 오류확인 size가 0이면 from은 맞으나 to는 다름 
            ArrayList<Wifi> wifis = (ArrayList<Wifi>) root.TbPublicWifiInfo.row;
            if(root.TbPublicWifiInfo.row.size() != 0) {
            	// 데이터 넣기
            	DB.insertWifi(wifis);	
            	System.out.println(wifiURL);
                
            	// 다음 데이터를 가져오기 위해 재귀 호출
            	openWifiApi(to + 1, to + 1000);
            }	
            
            return root.TbPublicWifiInfo.list_total_count;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
		
		return -1;
		
	}

}
