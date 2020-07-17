package bat.ke.qq.com.learnjuc.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.LockSupport;


public class AtomicStampedReferenceTest {

    public static void main(String[] args) {
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(1,1);

        new Thread(()->{
            int[] stampHolder = new int[1];
            int value = (int) atomicStampedReference.get(stampHolder);
            int stamp = stampHolder[0];
            System.out.println("Thread1 read value: " + value + ", stamp: " + stamp);

            // 阻塞1s
            LockSupport.parkNanos(1000000000L);

            if (atomicStampedReference.compareAndSet(value, 3,stamp,stamp+1)) {
                System.out.println("Thread1 update from " + value + " to 3");
            } else {
                System.out.println("Thread1 update fail!");
            }
        },"Thread1").start();

        new Thread(()->{
            int[] stampHolder = new int[1];
            int value = (int)atomicStampedReference.get(stampHolder);
            int stamp = stampHolder[0];
            System.out.println("Thread2 read value: " + value+ ", stamp: " + stamp);
            if (atomicStampedReference.compareAndSet(value, 2,stamp,stamp+1)) {
                System.out.println("Thread2 update from " + value + " to 2");

                // do something

                value = (int) atomicStampedReference.get(stampHolder);
                stamp = stampHolder[0];
                System.out.println("Thread2 read value: " + value+ ", stamp: " + stamp);
                if (atomicStampedReference.compareAndSet(value, 1,stamp,stamp+1)) {
                    System.out.println("Thread2 update from " + value + " to 1");
                }
            }
        },"Thread2").start();
    }
}
