package bat.ke.qq.com.learnjuc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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
