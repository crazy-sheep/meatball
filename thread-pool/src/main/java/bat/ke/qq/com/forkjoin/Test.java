package bat.ke.qq.com.forkjoin;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.*;

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
