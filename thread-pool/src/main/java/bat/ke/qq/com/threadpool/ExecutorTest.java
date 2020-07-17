package bat.ke.qq.com.threadpool;

import java.util.concurrent.*;


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
