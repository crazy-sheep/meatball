package bat.ke.qq.com.threadpool;

import java.util.concurrent.*;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
public class ExecutorTest {

    public static void main(String[] args) {
        // 线程池
        ExecutorService executorService =  new ThreadPoolExecutor(2, 5,10000L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());



        for (int i=0;i<100;i++){
            executorService.execute(new TaskRunnale());

            executorService.submit(new TaskCallable());

        }


    }
}
