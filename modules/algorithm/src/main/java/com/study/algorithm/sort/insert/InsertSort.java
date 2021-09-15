package com.study.algorithm.sort.insert;

import com.study.algorithm.sort.Sorter;
import java.util.Random;

/** 插入排序 */
public class InsertSort implements Sorter<Number[]> {

  @Override
  public void sort(Number[] items, Order order) {
    for (int i = 1; i < items.length; i++) {
      Number tmp = items[i];
      int j = i - 1;
      for (; j >= 0; j--) {
        if (order == Order.ASC
            ? tmp.doubleValue() < items[j].doubleValue()
            : tmp.doubleValue() > items[j].doubleValue()) {
          items[j + 1] = items[j];
        } else {
          break;
        }
      }
      items[j + 1] = tmp;
    }
  }

  @Override
  public Number[] generate(long count) {
    Integer[] result = new Integer[(int) count];
    for (int i = 0; i < count; i++) {
      final int item = new Random().nextInt(50);
      result[i] = item;
    }
    return result;
  }
}
