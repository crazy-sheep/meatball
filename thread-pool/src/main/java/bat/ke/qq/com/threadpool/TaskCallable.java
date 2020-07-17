package bat.ke.qq.com.threadpool;

import java.util.concurrent.Callable;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
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
