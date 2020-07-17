package bat.ke.qq.com.learnjuc.thread;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
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

