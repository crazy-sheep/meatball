package bat.ke.qq.com.learnjuc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
public class ReentrantLockTest {

    private static  int sum = 0;

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(()->{
                lock.lock();  // state=1
                try{
                    for (int j = 0; j < 10000; j++) {
                        sum++;
                    }
                }finally {
                    // 避免死锁
                    lock.unlock();  //state=0
                }
            });
            thread.start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(sum);



    }

}
