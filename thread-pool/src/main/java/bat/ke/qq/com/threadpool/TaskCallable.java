package bat.ke.qq.com.threadpool;

import java.util.concurrent.Callable;


public class TaskCallable implements Callable {
    @Override
    public Object call() throws Exception {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" callable execute");
        return null;
    }
}
