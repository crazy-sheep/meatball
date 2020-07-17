package bat.ke.qq.com.forkjoin.recursivetask;

import java.util.concurrent.RecursiveTask;

/**
 * The class first sums an array sequentially then sums the array using the F/J framework.
 * This proves that for < 100 computational steps, sequential is better.
 * <p>
 * To prove that for > 100 computational steps, F/J is better, change boolean: extraWork = true;
 */
class LongSum extends RecursiveTask<Long> {
    // 任务拆分最小阀值
    static final int SEQUENTIAL_THRESHOLD = 1000;

    int low;
    int high;
    int[] array;

    LongSum(int[] arr, int lo, int hi) {
        array = arr;
        low = lo;
        high = hi;
    }

    protected Long compute() {

        //当任务拆分到小于等于阀值时开始求和
        if (high - low <= SEQUENTIAL_THRESHOLD) {

            long sum = 0;
            for (int i = low; i < high; ++i) {
                sum += array[i];

            }

            return sum;

        } else {  // 任务过大继续拆分
            int mid = low + (high - low) / 2;
            LongSum left = new LongSum(array, low, mid);
            LongSum right = new LongSum(array, mid, high);
            // 将任务放入队列并异步执行  开启一个子任务
            left.fork();
           // right.fork();
            // 等待计算完成并返回计算结果
            long rightAns = right.compute();
            long leftAns = left.join();
            return leftAns + rightAns;
        }
    }
}

       