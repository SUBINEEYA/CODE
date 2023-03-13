package com.example.JavaStudy;

class Ex7_2{
    public static void main(String args[]){
        Child child = new Child();
        child.method();
    }
}


class Parent {
    int x = 10; //super.x 
}

class Child extends Parent {
    int x = 20; //this.x 

    void method(){
        System.out.println("x=" + x);   //x = 20
        System.out.println("this.x=" + this.x); // this.x = 20
        System.out.println("super.x=" + super.x); // super.x = 10
    }
}
