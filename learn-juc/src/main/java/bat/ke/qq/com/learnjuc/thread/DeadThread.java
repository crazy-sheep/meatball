package bat.ke.qq.com.learnjuc.thread;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 * 死锁
 */
public class DeadThread {
    private static String a = "a";
    private static String b = "b";

    public static void main(String[] args) {
        Thread threadA = new Thread(()->{
            synchronized (a) {
                System.out.println("threadA进入a同步块，执行中...");
                try {
                    Thread.sleep(2000);
                    synchronized (b) {
                        System.out.println("threadA进入b同步块，执行中...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"threadA");

        Thread threadB = new Thread(()->{
            synchronized (b) {
                System.out.println("threadB进入b同步块，执行中...");
                synchronized (a) {
                    System.out.println("threadB进入a同步块，执行中...");
                }
            }
        },"threadB");

        threadA.start();
        threadB.start();


    }

}
