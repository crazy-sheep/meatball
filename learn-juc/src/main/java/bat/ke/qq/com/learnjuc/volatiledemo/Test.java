package bat.ke.qq.com.learnjuc.volatiledemo;

import bat.ke.qq.com.learnjuc.lock.SimpleLock;

import java.math.BigDecimal;
import java.util.HashMap;


public class Test {


    private  static volatile int sum = 0;
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    sum++;
                }
            });
            thread.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(sum);

    }

}
