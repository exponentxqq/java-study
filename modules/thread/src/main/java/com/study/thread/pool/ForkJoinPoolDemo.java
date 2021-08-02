package com.study.thread.pool;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import lombok.AllArgsConstructor;

public class ForkJoinPoolDemo {
  public static void main(String[] args) {
    final long[] array = new long[2000];
    long expectedSum = 0;
    for (int i = 0; i < array.length; i++) {
      array[i] = new Random(0).nextInt(10000);
      expectedSum += array[i];
    }
    System.out.println("expected sum: " + expectedSum);

    final SumTask task = new SumTask(array, 0, array.length);
    final Long result = ForkJoinPool.commonPool().invoke(task);
    System.out.println("Fork/Join sum: " + result);
  }
}

@AllArgsConstructor
class SumTask extends RecursiveTask<Long> {
  static final int THRESHOLD = 500;
  private long[] array;
  private int start;
  private int end;

  @Override
  protected Long compute() {
    if (end - start <= THRESHOLD) {
      // 如果任务足够小,直接计算:
      long sum = 0;
      for (int i = start; i < end; i++) {
        sum += array[i];
        try {
          Thread.sleep(1);
        } catch (InterruptedException ignored) {
          // ignored
        }
      }
      return sum;
    }
    // 任务太大,一分为二
    int middle = (end + start) / 2;
    System.out.println(
        String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
    final SumTask subTask1 = new SumTask(array, start, middle);
    final SumTask subTask2 = new SumTask(array, middle, end);
    invokeAll(subTask1, subTask2);
    final Long subResult1 = subTask1.join();
    final Long subResult2 = subTask2.join();
    System.out.println("sub task result: " + (subResult1 + subResult2));
    return subResult1 + subResult2;
  }
}
