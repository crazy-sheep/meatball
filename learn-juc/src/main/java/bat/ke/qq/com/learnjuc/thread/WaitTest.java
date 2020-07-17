package bat.ke.qq.com.learnjuc.thread;

import java.util.concurrent.locks.LockSupport;

public class WaitTest {

    public void testWaitMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName()+" begin wait()");
                lock.wait();
                //LockSupport.park();

                System.out.println(Thread.currentThread().getName()+" end wait()");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testNotifyMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName()+"begin notify()");
                lock.notify();
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+"end notify()");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        WaitTest test = new WaitTest();

       Thread t1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                test.testWaitMethod(lock);
            }
        },"threadA");

        Thread t2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                test.testNotifyMethod(lock);
            }
        },"threadB");
        t1.start();
       t2.start();

        try {
            Thread.sleep(5000);
           //t1.interrupt();
            //LockSupport.unpark(t1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}