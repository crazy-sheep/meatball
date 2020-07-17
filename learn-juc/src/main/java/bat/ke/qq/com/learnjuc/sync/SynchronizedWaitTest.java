package bat.ke.qq.com.learnjuc.sync;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
public class SynchronizedWaitTest {


    public void test() {
        System.out.println(Thread.currentThread().getName()+" start");
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+" execute");
            try {

                //Thread.sleep(5000);
                //
                wait(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" end");
        }

    }



    public static void main(String[] args) {
        SynchronizedWaitTest test = new SynchronizedWaitTest();

        for(int i=0;i<2;i++){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.test();
                }
            },"thread"+i).start();
        }



    }


}
