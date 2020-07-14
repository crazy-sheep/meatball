package com.demo.meatball.设计模式.代理模式;

import org.bytedeco.javacpp.presets.opencv_core;

public class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }
    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
