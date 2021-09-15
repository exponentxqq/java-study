package com.study.algorithm.sort.count;

import com.study.algorithm.sort.Sorter;
import java.util.Random;

/** 计数排序，只能用于正整数 */
public class CountSort implements Sorter<Integer[]> {

  @Override
  public void sort(Integer[] items, Order order) {
    int max = items[0];
    int min = items[0];
    for (Integer item : items) {
      if (item > max) {
        max = item;
      }
      if (item < min) {
        min = item;
      }
    }
    int[] counter = new int[max + 1];
    for (Integer item : items) {
      counter[item] += 1;
    }
    int index = order == Order.ASC ? 0 : items.length - 1;
    for (int i = 0; i < counter.length; i++) {
      for (int j = 0; j < counter[i]; j++) {
        items[order == Order.ASC ? index++ : index--] = i;
      }
    }
  }

  @Override
  public Integer[] generate(long count) {
    Integer[] result = new Integer[(int) count];
    for (int i = 0; i < count; i++) {
      final int item = new Random().nextInt(50);
      result[i] = item;
    }
    return result;
  }
}
