package bat.ke.qq.com.learnjuc.volatiledemo;

/**
 * -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -Xcomp
 *
 */
public class VisibilityTest {
    // JMM模型
    // volatile可见性   ？   lock addl $0x0,(%rsp)  触发缓存一致性协议
    private volatile boolean  flag = true;

    public void refresh(){
        flag = false;
        System.out.println(Thread.currentThread().getName()+"修改flag");
    }

    public void load(){
        System.out.println(Thread.currentThread().getName()+"开始执行.....");
        int i=0;
        while (flag){
            i++;
            //Todo
            shortWait(1000000);
            //System.out.println(i);
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println(Thread.currentThread().getName()+"跳出循环: i="+ i);
    }

    public static void main(String[] args){

        VisibilityTest test = new VisibilityTest();
        new Thread(() -> test.load(), "threadA").start();
        try {
            Thread.sleep(2000);
            new Thread(()->test.refresh(),"threadB").start();
        } catch (InterruptedException e) {
            e.printStackTrace();
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
