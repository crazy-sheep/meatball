package bat.ke.qq.com.learnjuc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
public class ThreadLocalDemo {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        // 线程属性复用
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i=0;i<2;i++){
            ThreadDemo thread = new ThreadDemo();
            executorService.execute(thread);
        }
    }

    private static class ThreadDemo extends Thread{
        private static boolean flag = true;

        @Override
        public void run() {
            if(flag){
                threadLocal.set(this.getName()+",session信息.");
                flag = false;
            }
            System.out.println(this.getName()+" 线程是"+threadLocal.get());

            //threadLocal.remove();
        }
    }
}
