package bat.ke.qq.com.learnjuc.lock;

import java.util.concurrent.*;

/**
 * CyclicBarrier(栅栏)允许一组线程互相等待，直到到达某个公共屏障点 (Common Barrier Point)
 * 闭锁用于等待countDown事件，而栅栏用于等待其他线程。
 *
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "开始等待其他线程");
                        cyclicBarrier.await();
                        System.out.println(Thread.currentThread().getName() + "开始执行");
                        // 模拟业务处理
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName() + "执行完毕");


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }

    }
}

