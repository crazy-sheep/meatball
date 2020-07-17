package bat.ke.qq.com.learnjuc.volatiledemo;

/**
 * 查看汇编指令
 * -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -Xcomp
 *  DCL为什么要使用volatile
 */
public class SingletonFactory {


    private volatile static SingletonFactory myInstance;
    public static SingletonFactory getMyInstance() {
        if (myInstance == null) {
            synchronized (SingletonFactory.class) {
                if (myInstance == null) {
                    myInstance = new SingletonFactory();
                }
            }
        }
        return myInstance;
    }

    public static void main(String[] args) {
        SingletonFactory.getMyInstance();
    }
}
