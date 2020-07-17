package bat.ke.qq.com.learnjuc.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * 中断
 */
public class ThreadInterruptTest {

    static int i = 0;

    public static void main(String[] args)  {
        System.out.println("begin");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                while (true) {
                    i++;
                    System.out.println(i);
                    try {
                        //Thread.sleep(5000);
                        wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //LockSupport.park();
                    // Thread.interrupted()  会清掉中断标志位
                    // Thread.currentThread().isInterrupted()  不会清掉中断标志位
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("======");
                        //break;
                    }

//
                    if(i==10){
                        break;
                    }

                }
            }
        });

        t1.start();
        // 仅仅只是设置t1的中断标志位  flag=true,不会中断线程
        // sleep() 会被中断唤醒 ，抛出sleep interrupted异常
        // wait() & sychronized   Object monitor  会被中断唤醒 ，抛出InterruptedException异常
        // LockSupport.park & unpark  基于Thread等待/唤醒机制  counter=0 阻塞 counter=1 被唤醒，继续执行
        // LockSupport.park 会被中断唤醒
        t1.interrupt();
        //LockSupport.unpark(t1);


    }
}
