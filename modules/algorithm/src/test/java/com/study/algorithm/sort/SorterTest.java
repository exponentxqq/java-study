package com.study.algorithm.sort;

import com.study.algorithm.sort.Sorter.Order;

public abstract class SorterTest<T> {
  protected abstract void assertSorted(T items, Order order);

  protected void assertSorted(T items) {
    assertSorted(items, Order.ASC);
  }
}
