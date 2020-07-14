package com.demo.meatball.设计模式.代理模式;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image xx = new ProxyImage("xx");
        xx.display();
        xx.display();
    }
}
