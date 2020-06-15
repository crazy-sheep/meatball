package com.meatball.meatball.factory.Impl;

import com.meatball.meatball.factory.NewCar;

public class BmwCar implements NewCar {

    @Override
    public void newCar() {
        System.out.println("创建一辆宝马car");
    }
}
