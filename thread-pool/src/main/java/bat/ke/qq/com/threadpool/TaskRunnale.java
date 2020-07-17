package bat.ke.qq.com.threadpool;


public class TaskRunnale implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" Runnable execute");
    }
}
