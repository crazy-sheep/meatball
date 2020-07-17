package bat.ke.qq.com.learnjuc.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模拟并发，多个线程在某一时刻同时开始执行
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        // 闭锁
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //减1   state=0
                        countDownLatch.countDown();
                        System.out.println(Thread.currentThread().getName()
                                + " counts = " +countDownLatch.getCount());
                        // 阻塞
                        countDownLatch.await();

                        System.out.println(Thread.currentThread().getName() + " end");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}

