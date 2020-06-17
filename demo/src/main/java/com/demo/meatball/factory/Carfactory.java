package com.demo.meatball.factory;

import com.demo.meatball.factory.Impl.BmwCar;
import com.demo.meatball.factory.Impl.DazhongCar;

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
