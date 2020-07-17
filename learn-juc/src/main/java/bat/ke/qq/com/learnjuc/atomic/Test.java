package bat.ke.qq.com.learnjuc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
public class Test {
    private static AtomicInteger sum = new AtomicInteger(0);
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    // 原子自增  CAS
                    sum.getAndIncrement();
                    //TODO

                }
            });
            thread.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sum.get());

    }

}
