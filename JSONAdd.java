package com.example.demo;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONAdd {

    String json;

    void jsonadd(){

        //inner 라는 json 객체 생성함 
        JSONObject inner = new JSONObject();
        inner.put("name","강수빈");
        inner.put("gender","여자");
        inner.put("age","30");
        inner.put("address","부산");
        inner.put("hobby","등산");
        
        //outer 라는 json 객체 생성함 
        JSONObject outer = new JSONObject();
        //inner json객체 위에 inf 삽입 
        outer.put("inf",inner);

        json = outer.toJSONString();

        System.out.println(json);


        /* 이런 형태로 저장되어 있다 
         * {
         *   "inf":{
         *          "address":"부산",
         *          "gender":"여자",
         *          "name":"강수빈",
         *          "age":"30", 
         *          "hobby":"등산"
         *         }
         * }
         */
    }

    public static void main(String[] args) throws Exception {


        //json 객체 가져오기 jsonAdd
        JSONAdd jsonAdd = new JSONAdd();

        jsonAdd.jsonadd();


        //파싱 객체를 생성함 (이때 parser가 우리가 사용할 수 있는 형태로 변환해주는 역할 )
        JSONParser parser = new JSONParser();

        // json문자열을 parse() 해서 JSON Object형태로 변환 
        JSONObject obj = (JSONObject)parser.parse(jsonAdd.json);

        //json 객체안에 inf 라는 key값을 가져옴 
        JSONObject inf = (JSONObject)obj.get("inf");
        //이때 inf객체 안에는 inf 데이터가 들어있음 


        //key값을 사용하여 데이터를 가져옴 
        String name = (String)inf.get("name");
        String gender = (String)inf.get("gender");
        String age = (String)inf.get("age");
        String address = (String)inf.get("address");
        String hobby = (String)inf.get("hobby");
        

        //출력하기
        System.out.println("이름 : " + name);
        System.out.println("성별 : " + gender);
        System.out.println("나이 : " + age);
        System.out.println("주소 : " + address);
        System.out.println("취미 : " + hobby);
    }
    
}
