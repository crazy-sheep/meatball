package com.demo.meatball.设计模式.单例模式;

import com.demo.meatball.设计模式.单例模式.双检锁.DoubleChecked;
import com.demo.meatball.设计模式.单例模式.懒汉式.Persion;

public class MyThread extends Thread{
    //2.重写run方法
    @Override
    public void run() {
        //3.将要在线程中执行的代码编写在run方法中
        for(int i = 0; i < 1000; i++) {
            Persion doubleChecked = Persion.getUnsafeInstance();
            System.out.println(i +":============>"+doubleChecked);
        }
    }
}
