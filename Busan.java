package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;







public class Busan {
    public static void main(String[] args) throws Exception {
    
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6260000/fbusangmgtourinfo/getgmgtourinfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=YQLyi%2FEHor54WpURPJtX8gPgDNo%2BwqK0HiG0268PI4aO7eobC4FJEfTKxJw26N%2FcAiYCp0IP93TRO5XyE9oILQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*검색건수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*JSON방식으로 호출 시 파라미 resultType=json 입력*/
       
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        BufferedReader rd;

        //정상호출 responsecode == 200
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {

            //에러발생시
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

        //JSON 파싱 (jsonObject형으로 만들기)    
       
            // JSON parser 만들어 문자열 데이터를 객체화한다.
            // 만들어진 json 객체는 JSONObject 클래스를 사용해서 저장됨 
            JSONParser jsonPares = new JSONParser();
            JSONObject obj = (JSONObject)jsonPares.parse(sb.toString()); //stringBuilder 에 저장된 정보

            //꺼내기 
            JSONObject getgmgtourinfo = (JSONObject)obj.get("getgmgtourinfo");
            JSONObject body = (JSONObject)getgmgtourinfo.get("body");
            JSONObject items = (JSONObject)body.get("items");
            JSONArray itemArr = (JSONArray)items.get("item");
            System.out.println(itemArr);


            System.out.println("============================================================================");
           for (int i = 0; i < itemArr.size(); i++) {

            //배열 안도 JSON형식이기 때문에 JSONObject로 꺼내야됨
            JSONObject object = (JSONObject) itemArr.get(i);

            //JSON NAME으로 추출함
            System.out.println("이름:" + object.get("name"));
            System.out.println("종류:" + object.get("cate1_nm"));
            System.out.println("장소설명 :"+object.get("itemcntnts") );
            System.out.println("");
   
           }
    
    }

}
