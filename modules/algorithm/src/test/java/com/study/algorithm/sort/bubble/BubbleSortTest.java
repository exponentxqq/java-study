package com.study.algorithm.sort.bubble;

import com.study.algorithm.sort.Sorter.Order;
import com.study.algorithm.sort.SorterTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BubbleSortTest extends SorterTest<Number[]> {
  @Test
  void test1() {
    final BubbleSort bubbleSort = new BubbleSort();
    final Number[] generate = bubbleSort.generate(10);
    bubbleSort.sort(generate);
    assertSorted(generate);

    bubbleSort.sort(generate, Order.DESC);
    assertSorted(generate, Order.DESC);
  }

  @Override
  public void assertSorted(Number[] numbers, Order order) {
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
