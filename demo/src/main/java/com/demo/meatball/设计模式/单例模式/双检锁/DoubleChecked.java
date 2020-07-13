package com.demo.meatball.设计模式.单例模式.双检锁;

import org.bytedeco.javacpp.presets.opencv_core;

//双检锁， 多线程安全，性能高
//这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
//getDoubleChecked() 创建实例的性能对应用程序很关键。
public class DoubleChecked {
    private volatile static DoubleChecked doubleChecked;
    private String name;
    private DoubleChecked() { }

    public static DoubleChecked getDoubleChecked(){
        if (doubleChecked == null){
            synchronized (DoubleChecked.class){
                if (doubleChecked == null){
                    doubleChecked = new DoubleChecked();
                    doubleChecked.setName("张三");
                }
            }
        }
        return doubleChecked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
