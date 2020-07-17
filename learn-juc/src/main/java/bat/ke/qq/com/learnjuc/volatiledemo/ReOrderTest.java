package bat.ke.qq.com.learnjuc.volatiledemo;

import sun.misc.Unsafe;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 *
 *
 */
public class ReOrderTest {

    private static int x = 0, y = 0;
    // volatile禁止重排序  有序性  添加内存屏障  lock; addl $0,0(%%rsp)
    // x86处理器会在volatile写之后插入StoreLoad
    //  lock; addl $0,0(%%rsp)
    private static  int a = 0, b = 0;



    public static void main(String[] args) throws InterruptedException{
        int i=0;
        while (true) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            /**
             *  x,y:   00     01     10     11
             */
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    shortWait(20000);
                    a = 1;// volatile写之后插入StoreLoad
                    //手动添加内存屏障
                    UnsafeFactory.getUnsafe().storeFence();
                    x = b;
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    //手动添加内存屏障
                    UnsafeFactory.getUnsafe().storeFence();
                    y = a;
                }
            });

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            System.out.println("第" + i + "次（" + x + "," + y + ")");

            if (x==0&&y==0){
                break;
            }

        }

    }

    public static void shortWait(long interval){
        long start = System.nanoTime();
        long end;
        do{
            end = System.nanoTime();
        }while(start + interval >= end);
    }



}
