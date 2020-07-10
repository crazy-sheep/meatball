package com.demo.meatball.设计模式.单例模式;

import com.demo.meatball.设计模式.单例模式.双检锁.DoubleChecked;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SingletonTest {
    private static final Semaphore activeThreadSize = new Semaphore(5);
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(10);
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        /*threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    activeThreadSize.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DoubleChecked doubleChecked = DoubleChecked.getDoubleChecked();
                System.out.println("==============>"+ doubleChecked.getName());
                activeThreadSize.release();

            }
        });*/


    }
}
