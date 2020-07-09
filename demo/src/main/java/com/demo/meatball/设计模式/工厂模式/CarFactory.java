package com.demo.meatball.设计模式.工厂模式;

public class CarFactory {
    public NewCar newCar(String s){
        if (s.equals("BYD")){
            return new BydCar();
        }else if (s.equals("BMW")){
            return new BmwCar();
        }
        return null;
    }
}
