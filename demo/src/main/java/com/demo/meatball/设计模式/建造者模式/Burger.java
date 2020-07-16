package com.demo.meatball.设计模式.建造者模式;

public abstract class Burger implements Item{
    @Override
    public Packing packing(){
        return new Wrapper();
    }
    @Override
    public abstract float price();
}
