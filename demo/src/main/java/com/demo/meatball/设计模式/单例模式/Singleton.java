package com.demo.meatball.设计模式.单例模式;

public class Singleton {
    public static void main(String[] args) {
        Persion instance1 = Persion.getInstance();
        instance1.getName();
        Persion instance2 = Persion.getInstance();
        instance2.getName();
        if (instance1.equals(instance2)){
            System.out.println("同一个");
        }else {
            System.out.println("不同");
        }
    }
}
