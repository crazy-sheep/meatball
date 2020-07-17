package bat.ke.qq.com.learnjuc.lock;

import java.util.concurrent.Semaphore;

/**
 * Semaphore是一个计数信号量,Semaphore经常用于限制获取资源的线程数量
 *
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        // 声明3个窗口  state:  资源数
        Semaphore windows = new Semaphore(3);

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 占用窗口
                        windows.acquire();
                        System.out.println(Thread.currentThread().getName() + ": 开始买票");
                        //模拟买票流程
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread().getName() + ": 购票成功");
                        // 释放窗口
                        windows.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }
}