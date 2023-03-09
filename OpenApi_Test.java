package com.example.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.data.repository.support.Repositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;

@RestController
@RequestMapping("/api")
public class OpenApi_Test {

    @GetMapping("/place")
    public String callApi() throws IOException {
        // StringBuilder result = new StringBuilder();

        // url 생성
        String urlStr = "http://apis.data.go.kr/6260000/fbusangmgtourinfo/getgmgtourinfo?" +
                "serviceKey="
                + "YQLyi%2FEHor54WpURPJtX8gPgDNo%2BwqK0HiG0268PI4aO7eobC4FJEfTKxJw26N%2FcAiYCp0IP93TRO5XyE9oILQ%3D%3D"
                + "&pageNo=1" + "&numOfRows=10" + "&resultType=json";

        URL url = new URL(urlStr);

        //openConnection은 URLConnection이라는 추상 클래스 타입으로 티런하므로 강제 형변환해서 일반 클래스 타입으로 변경
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //get 방식으로 가져옴
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        BufferedReader br;

                //문자열 읽을 스트림 생성함 
        br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        //문자열을 읽기 위한 임시변수 생성 
        StringBuilder sb = new StringBuilder();
        while(true) {
            // 한줄 읽어오기
            String line = br.readLine();
            // 읽은 데어터가 없으면 종료
            if(line == null) {
                break;
            }
            //읽은 데이터가 있으면 sb에 추가
            sb.append(line + "\n");
        }			
        // 연결 종료
        br.close();
        conn.disconnect();
        System.out.println(sb.toString());
        //파싱 결과를 저장할 변수 생성 
        // Map에 저장
        List<Map<String, Object>> list = new ArrayList<>(); 
        //데이터 파싱 
        try{
            //텍스트가 존재할 떄 수행한당
            if(sb.toString() != null && sb.toString().length()>0) {
                //key값 객체로 가져오기
                JSONParser jsonPares = new JSONParser();
                JSONObject obj = (JSONObject)jsonPares.parse(sb.toString());
                JSONObject getgmgtourinfo = (JSONObject)obj.get("getgmgtourinfo");
                JSONObject body = (JSONObject)getgmgtourinfo.get("body");
                JSONObject items = (JSONObject)body.get("items");
                JSONArray itemArr = (JSONArray)items.get("item");

                for (int i = 0; i < itemArr.size(); i++) {
                    JSONObject object = (JSONObject) itemArr.get(i);

                    // System.out.println("이름:" + object.get("name"));
                    // System.out.println("종류:" + object.get("cate1_nm"));
                    // System.out.println("장소설명 :"+object.get("itemcntnts") );
                    // System.out.println("");

                    String name = (String)object.get("name");
                    String cate1_nm = (String)object.get("cate1_nm");
                    String itemcntnts = (String)object.get("itemcntnts");

                    //Map으로 생성 
                    Map<String, Object> map = new HashMap<>();
					map.put("name", name);
					map.put("cate1_nm",cate1_nm);
					map.put("itemcntnts",itemcntnts);
					// list에 추가
					list.add(map);
                }

            }
        }catch(Exception e){
            System.out.println("실패");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return list.toString();
    }

}
