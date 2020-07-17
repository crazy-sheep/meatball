package bat.ke.qq.com.learnjuc.map;

import java.util.HashMap;


public class HashMapDemo {

    public static void main(String[] args) {

        HashMap map = new HashMap<HashMapDemo,Integer>(1);
        for (int i=0;i<100;i++){
            map.put(new HashMapDemo(),i);
        }
        System.out.println(map);
    }

    /**
     * 重写hashcode
     * @return
     */
    @Override
    public int hashCode() {
        //return super.hashCode();
        return 1;
    }
}
