package com.demo.meatball.factory.Impl;


import com.demo.meatball.factory.NewCar;

public class BmwCar implements NewCar {

    @Override
    public void newCar() {
        System.out.println("创建一辆宝马car");
    }
}
