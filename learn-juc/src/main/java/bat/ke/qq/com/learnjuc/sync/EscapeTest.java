package bat.ke.qq.com.learnjuc.sync;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
public class EscapeTest {

    /**
     * 逃逸分析，是一种可以有效减少Java 程序中同步负载和内存堆分配压力的跨函数
     * 全局数据流分析算法。通过逃逸分析，Java Hotspot编译器能够分析出一个新的对象
     * 的引用的使用范围从而决定是否要将这个对象分配到堆上
     * 逃逸分析的基本行为就是分析对象动态作用域：当一个对象在方法中被定义后，
     * 它可能被外部方法所引用，例如作为调用参数传递到其他地方中，称为方法逃逸。
     *
     * 使用逃逸分析，编译器可以对代码做如下优化：
     * 1.同步省略。如果一个对象被发现只能从一个线程被访问到，
     * 那么对于这个对象的操作可以不考虑同步。
     *
     * 2.将堆分配转化为栈分配。如果一个对象在子程序中被分配，要使指向该对象的指针永远
     * 不会逃逸，对象可能是栈分配的候选，而不是堆分配。
     *
     * 3.分离对象或标量替换。有的对象可能不需要作为一个连续的内存结构存在也可以被访问到，
     * 那么对象的部分（或全部）可以不存储在内存，而是存储在CPU寄存器中。
     *
     * 方法逃逸和线程逃逸
     * 方法逃逸(对象逃出当前方法)：
     *  当一个对象在方法里面被定义后，它可能被外部方法所引用，例如作为调用参数传递到其它方法中。
     * 线程逃逸((对象逃出当前线程)：
     *  这个对象甚至可能被其它线程访问到，例如赋值给类变量或可以在其它线程中访问的实例变量
     *
     * 进行两种测试
     * 关闭逃逸分析，同时调大堆空间，避免堆内GC的发生，如果有GC信息将会被打印出来
     * VM运行参数：-Xmx4G -Xms4G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
     *
     * 开启逃逸分析  jdk8默认开启
     * VM运行参数：-Xmx4G -Xms4G -XX:+DoEscapeAnalysis -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
     *
     * 执行main方法后
     * jps 查看进程
     * jmap -histo 进程ID
     *
     */

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            alloc();
        }

        long end = System.currentTimeMillis();

        System.out.println("执行时间：" + (end - start) + " ms");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }


    /**
     * JIT编译时会对代码进行逃逸分析 ,将堆分配转化为栈分配
     * Ponit没有逃逸
     */
    private static String alloc() {
        Point point = new Point();
        return point.toString();
    }

    /**
     *同步省略（锁消除）  JIT编译阶段优化，JIT经过逃逸分析之后发现无线程安全问题，就会做锁消除
     */
    public static void test() {
        Point point = new Point();
        synchronized(point) {
            System.out.println(point);
        }
    }

    /**
     * 标量替换
     *
     */
    private static void test2() {
        Point point = new Point(1,2);
        System.out.println("point.x="+point.getX()+"; point.y="+point.getY());

//        int x=1;
//        int y=2;
//        System.out.println("point.x="+x+"; point.y="+y);
    }


}




class Point{
    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}