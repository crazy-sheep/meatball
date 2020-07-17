package bat.ke.qq.com.learnjuc.sync;

import bat.ke.qq.com.learnjuc.volatiledemo.UnsafeFactory;


public class Test {

    private  static  int sum = 0;

    public static Object o="";

    //方法上 ACC_SYNCHRONIZED
    public  static void add(){
        // 线程安全  monitorenter   monitorexit
        // 线程上下文的切换  用户态切换到内核态
        synchronized (Test.class){
        //加锁
       // UnsafeFactory.getUnsafe().monitorEnter(o);
            sum++;
        }
    }

    public  static void add2(){
        // 线程安全  monitorenter   monitorexit
       // synchronized (Test.class){
            sum++;
            //解锁
       // UnsafeFactory.getUnsafe().monitorExit(o);
       // }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    add();
                }
            });
            thread.start();
        }




        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(sum);

    }


}
