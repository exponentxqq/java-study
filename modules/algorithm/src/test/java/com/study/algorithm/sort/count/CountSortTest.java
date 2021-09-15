package com.study.algorithm.sort.count;

import com.study.algorithm.sort.Sorter.Order;
import com.study.algorithm.sort.SorterTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountSortTest extends SorterTest<Integer[]> {
  @Test
  void test1() {
    final CountSort countSort = new CountSort();
    final Integer[] generate = countSort.generate(10);
    countSort.sort(generate);
    assertSorted(generate);

    countSort.sort(generate, Order.DESC);
    assertSorted(generate, Order.DESC);
  }

  @Override
  public void assertSorted(Integer[] numbers, Order order) {
    boolean isSorted = true;
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i].doubleValue() > numbers[i - 1].doubleValue() && order == Order.DESC) {
        isSorted = false;
        break;
      } else if (numbers[i].doubleValue() < numbers[i - 1].doubleValue() && order == Order.ASC) {
        isSorted = false;
        break;
      }
    }
    Assertions.assertTrue(isSorted);
  }
}
