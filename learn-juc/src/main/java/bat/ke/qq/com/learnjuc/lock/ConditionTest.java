package bat.ke.qq.com.learnjuc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private String tv = "广告";


    public void waitTv() {
        lock.lock();
        try {
            while (tv.equals("广告")) {
                try {
                    condition.await();
                    if (tv.equals("广告")) {
                        System.out.println(Thread.currentThread().getName()
                                + " 骗人，还是广告");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " 愉快的追剧");
        }finally {
            lock.unlock();
        }
    }

    public void sendTrueMsg() {
        lock.lock();
        try {
            tv = "正剧";
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void sendFalseMsg() {
        lock.lock();
        try {
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionTest test = new ConditionTest();

        new Thread(()-> test.waitTv()).start();
        new Thread(()-> test.waitTv()).start();

        Thread.sleep(3000);
        test.sendFalseMsg();
        Thread.sleep(3000);
        test.sendTrueMsg();
    }
}