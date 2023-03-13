package com.example.JavaStudy;

 class Tv {
    boolean power; // 전원
    int channel; //채널

    void power(){
        power = !power; //전원 껐다 켰다
    }

    void channelUp(){ ++channel;} //채널 ++

    void channelDown(){ --channel;} //채널 --

}

class SmartTv extends Tv{
    boolean caption; // 스마트티비 자막기능 (on/off)
    
    void displayCaption(String text){
        if(caption){ //caption 상태가 true 일때 text 보여주기
            System.out.println(text);
        }
    }
}

class Ex7_1{
    public static void main(String args[]){
        SmartTv stv = new SmartTv(); // 객체생성
        stv.channel = 10; //조상 클래스로 부터 상속받음
        stv.channelUp(); //조상 클래스로부터 상속받음 

        System.out.println(stv.channel);
        stv.displayCaption("Hello,world"); // caption 기본값이 false이기 때문에 무시
        stv.caption = true; //캡션 기능을 킴
        stv.displayCaption("Hello,world");
    }
}
