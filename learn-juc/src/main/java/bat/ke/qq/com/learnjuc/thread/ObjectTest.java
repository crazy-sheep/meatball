package bat.ke.qq.com.learnjuc.thread;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;


public class ObjectTest {

    public static void main(String[] args) {
        Object obj = new Object();

        //obj.hashCode();
        //查看对象内部信息
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

//        synchronized (obj){
//            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
//        }

        // System.out.println("====================");
        //查看对象外部信息,包括引用的对象
       // System.out.println(GraphLayout.parseInstance(obj).toPrintable());
       // System.out.println("====================");

        //查看对象占用空间总大小
       // System.out.println(GraphLayout.parseInstance(obj).totalSize());
    }
}

