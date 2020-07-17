package bat.ke.qq.com.learnjuc.sync;


public class SynchronizedTest2 {

    StringBuffer buffer = new StringBuffer();

    /**
     锁粗化
     */
    public void test(){

        buffer.append("fox");
        buffer.append("ant");
        buffer.append("monkey");


    }

    /**
     * 锁消除:对一些不可能存在共享数据竞争的锁进行消除。
     *
     * -XX:+EliminateLocks 开启同步消除
     */
    public void test2(){
        Object object = new Object();
        // 不存在竞争  jvm  逃逸分析   同步省略
        synchronized (object){
           //TODO  业务逻辑
           i++;
        }
    }

    private static int i=0;
    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest2 synchronizedTest2 = new SynchronizedTest2();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    synchronizedTest2.test2();
                }
            });
            thread.start();
        }
        Thread.sleep(2000);
        System.out.println(i);
    }

}
