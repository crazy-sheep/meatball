package bat.ke.qq.com.forkjoin.arraysum;

import bat.ke.qq.com.forkjoin.util.Utils;

public class SumSequential {
    public static long sum(int[] arr){
        return SumUtils.sumRange(arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = Utils.buildRandomIntArray();
        System.out.printf("The array length is: %d\n", arr.length);

        long result = sum(arr);

        System.out.printf("The result is: %d\n", result);
    }
}
