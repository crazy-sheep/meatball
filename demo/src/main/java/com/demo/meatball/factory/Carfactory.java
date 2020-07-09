package com.demo.meatball.factory;

public class Carfactory {
    public NewCar getCar(String string){
        if (string == null){
            return null;
        }
        if (string.equals("bmw")){
            return new BmwCar();
        }else if (string.equals("dazhong")){
            return new DazhongCar();
        }
        return null;
    }
}
