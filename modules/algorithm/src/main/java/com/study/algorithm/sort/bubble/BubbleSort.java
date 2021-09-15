package com.study.algorithm.sort.bubble;

import com.study.algorithm.sort.Sorter;
import java.util.Random;

/** 冒泡排序 */
public class BubbleSort implements Sorter<Number[]> {
  @Override
  public void sort(Number[] items, Order order) {
    if (order == Order.ASC) {
      asc(items);
    } else {
      desc(items);
    }
  }

  @Override
  public Number[] generate(long count) {
    Number[] result = new Number[(int) count];
    for (int i = 0; i < count; i++) {
      final int item = new Random().nextInt();
      result[i] = item;
    }
    return result;
  }

  private void asc(Number[] items) {
    final int length = items.length;
    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        if (items[i].doubleValue() > items[j].doubleValue()) {
          final Number temp = items[i];
          items[i] = items[j];
          items[j] = temp;
        }
      }
    }
  }

  private void desc(Number[] items) {
    final int length = items.length;
    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        if (items[i].doubleValue() < items[j].doubleValue()) {
          final Number temp = items[i];
          items[i] = items[j];
          items[j] = temp;
        }
      }
    }
  }
}
