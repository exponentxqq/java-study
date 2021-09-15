package com.study.algorithm.sort;

public interface Sorter<T> {
  enum Order {
    ASC,
    DESC,
    ;
  }

  void sort(T items, Order order);

  default void sort(T items) {
    sort(items, Order.ASC);
  }

  T generate(long count);
}
