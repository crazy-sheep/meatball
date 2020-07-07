package com.demo.meatball.vo;

public class Persion {
    private static Persion instance = null;
    private Persion(){
        System.out.println("产生一个新对象：喵喵");
    }
    public static synchronized Persion getInstance(){
        if (instance == null){
            instance = new Persion();
        }else {
            System.out.println("已经存在对象");
        }
        return instance;
    }
    public void getName(){
        System.out.println("对象名");
    }
}
