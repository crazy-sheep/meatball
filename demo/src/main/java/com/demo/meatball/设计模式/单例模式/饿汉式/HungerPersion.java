package com.demo.meatball.设计模式.单例模式.饿汉式;

//饿汉式：
//多线程安全
public class HungerPersion {
    private static HungerPersion hungerPersion = new HungerPersion();
    private HungerPersion() { }

    public static HungerPersion getInstance(){
        return hungerPersion;
    }
}
