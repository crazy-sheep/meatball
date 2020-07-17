package bat.ke.qq.com.learnjuc.volatiledemo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;


public class UnsafeFactory {

    public static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
