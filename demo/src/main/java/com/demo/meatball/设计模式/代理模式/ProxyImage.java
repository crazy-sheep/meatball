package com.demo.meatball.设计模式.代理模式;

import org.bytedeco.javacpp.presets.opencv_core;

public class ProxyImage implements Image{

    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage ==null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
