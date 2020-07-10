package com.demo.meatball.设计模式.单例模式.懒汉式;
//======================》》》所谓单例就是将： 构造函数私有化，写一个唯一能创建类的方法入口，从而控制类的创建
//懒汉式：加上synchronized关键字，多线程 安全，性能差不常用，去掉synchronized关键字，多线程 不安全
//
public class Persion {
    private static Persion instance = null;
    private Persion(){
        System.out.println("产生一个新对象：喵喵");
    }
    public static Persion getUnsafeInstance(){
        if (instance == null){
            instance = new Persion();
        }else {
            System.out.println("已经存在对象");
        }
        return instance;
    }
    public static synchronized Persion getSafeInstance(){
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
