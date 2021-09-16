package com.study.algorithm.sort.merge;

import com.study.algorithm.sort.Sorter;
import java.util.Random;
import java.util.stream.IntStream;

/** 归并排序 */
public class MergeSort implements Sorter<Number[]> {

  @Override
  public void sort(Number[] items, Order order) {
    if (items.length < 2) {
      return;
    }
    sort(items, 0, items.length - 1, order);
  }

  private void sort(Number[] items, int low, int height, Order order) {
    if (low < height) {
      int middle = (low + height) / 2;
      sort(items, low, middle, order);
      sort(items, middle + 1, height, order);
      merge(items, low, middle, height, order);
    }
  }

  private void merge(Number[] items, int low, int middle, int height, Order order) {
    int left = low;
    int right = middle + 1;
    Number[] result = new Number[height - low + 1];
    int index = 0;
    while (left <= middle && right <= height) {
      if (items[left].doubleValue() < items[right].doubleValue()) {
        result[index++] = items[order == Order.ASC ? left++ : right++];
      } else {
        result[index++] = items[order == Order.ASC ? right++ : left++];
      }
    }
    while (left <= middle) {
      result[index++] = items[left++];
    }
    while (right <= height) {
      result[index++] = items[right++];
    }
    IntStream.range(0, result.length).forEach(i -> items[i + low] = result[i]);
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
