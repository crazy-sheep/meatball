package bat.ke.qq.com.learnjuc.thread;

import java.util.concurrent.TimeUnit;

public class StopThread2 {
    public static void main(String[] args) throws Exception {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        // 休眠1秒，main线程对CountThread进行中断，使CountThread能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();


        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();
        // 休眠1秒，main线程对Runner two进行取消，使CountThread能够感知on为false而结束
        // 注意： volatile 修饰标记位终止线程存在风险，某些场景不适用 ，推荐使用中断机制
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    private static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);
        }

        public void cancel() {
            on = false;
        }
    }
}