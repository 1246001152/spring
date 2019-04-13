package com.java.factory;

public class CarFactory {
    //非静态工厂
    public Car createCarFactory(){
        return new Car("大众",20.0);
    }
    //静态工厂
    public static Car createStaticCarFactory(){
        return new Car("奥迪",50.0);
    }
}
