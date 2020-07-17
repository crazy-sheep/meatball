package bat.ke.qq.com.forkjoin.recursivetask;


import bat.ke.qq.com.forkjoin.util.Utils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class LongSumMain {
	// 获取逻辑处理器数量  12
	static final int NCPU = Runtime.getRuntime().availableProcessors();

	static long calcSum;


	public static void main(String[] args) throws Exception {
		int[] array = Utils.buildRandomIntArray(200000000);

		// 单线程计算数组总和
 		calcSum = seqSum(array);
		System.out.println("seq sum=" + calcSum);

		LongSum ls = new LongSum(array, 0, array.length);
		// with number of threads to use
  		ForkJoinPool fjp  = new ForkJoinPool(NCPU);

		ForkJoinTask<Long> result = fjp.submit(ls);

		System.out.println("forkjoin sum=" + result.get());

		fjp.shutdown();

	}


	static long seqSum(int[] array) {
		long sum = 0;
		for (int i = 0; i < array.length; ++i)
			sum += array[i];
		return sum;
	}
}