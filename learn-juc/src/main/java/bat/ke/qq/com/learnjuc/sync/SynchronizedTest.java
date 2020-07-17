package bat.ke.qq.com.learnjuc.sync;

import bat.ke.qq.com.learnjuc.volatiledemo.UnsafeFactory;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 *
 * synchronized  jvm内置锁  Unsafe
 */
public class SynchronizedTest {
    public static int count;
    public static int count2;


    public   void test() {
        count++;
    }

    public  void test2(){
        count2++;
    }


    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();

        for(int i=0;i<10;i++){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<1000;i++){
                        test.test();
                        test.test2();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count+","+count2);

    }


}
