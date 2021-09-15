package com.study.algorithm.sort.merge;

import com.study.algorithm.sort.Sorter;

/** 归并排序 */
public class MergeSort implements Sorter<Number[]> {

  @Override
  public void sort(Number[] items, Order order) {
    if (items.length < 2) {
      return;
    }
    sort(items, 0, items.length - 1);
  }

  private void sort(Number[] items, int low, int height) {
    if (low < height) {
      int middle = (low + height) / 2;
      sort(items, low, middle);
      sort(items, middle + 1, height);
      merge(items, low, middle, height);
    }
  }

  private void merge(Number[] items, int low, int middle, int height) {}

  @Override
  public Number[] generate(long count) {
    return new Number[0];
  }
}
