package bat.ke.qq.com.learnjuc.lock;

import java.util.concurrent.locks.ReentrantLock;


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
