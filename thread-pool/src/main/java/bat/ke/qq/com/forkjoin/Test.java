package bat.ke.qq.com.forkjoin;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.*;
/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
public class Test {

    public static void main(String[] args) {


        int[] nums = {20,120,-50,300,-100};

        int min = Integer.MAX_VALUE;
//        for (int i:nums){
//            if(i<min){
//                min = i;
//            }
//        }
        //jdk8
        min = IntStream.of(nums).parallel().min().getAsInt();

        System.out.println(min);


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        numbers.parallelStream().forEach(System.out::print);
        System.out.println("");
        numbers.parallelStream().forEachOrdered(System.out::print);
    }
}
