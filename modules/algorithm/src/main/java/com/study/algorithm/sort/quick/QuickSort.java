package com.study.algorithm.sort.quick;

import com.study.algorithm.sort.Sorter;
import java.util.Random;

/** 快速排序 */
public class QuickSort implements Sorter<Number[]> {

  @Override
  public void sort(Number[] items, Order order) {
    sort(items, 0, items.length - 1, order);
  }

  private void sort(Number[] items, int start, int end, Order order) {
    if (start > end) {
      return;
    }
    Number base = items[start];
    int i = start;
    int j = end;
    while (i != j) {
      while (items[j].doubleValue() >= base.doubleValue() && i < j) {
        j--;
      }
      while (items[i].doubleValue() <= base.doubleValue() && i < j) {
        i++;
      }
      if (i < j) {
        Number tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
      }
    }

    items[start] = items[i];
    items[i] = base;
    sort(items, start, i - 1, order);
    sort(items, i + 1, end, order);
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
