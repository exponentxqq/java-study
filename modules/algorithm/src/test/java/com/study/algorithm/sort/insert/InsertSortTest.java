package com.study.algorithm.sort.insert;

import com.study.algorithm.sort.Sorter.Order;
import com.study.algorithm.sort.SorterTest;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InsertSortTest extends SorterTest<Number[]> {
  @Test
  void test() {
    final InsertSort insertSort = new InsertSort();
    final Number[] generate = insertSort.generate(10);
    System.out.println(Arrays.toString(generate));

    insertSort.sort(generate);
    System.out.println(Arrays.toString(generate));
    assertSorted(generate);

    insertSort.sort(generate, Order.DESC);
    System.out.println(Arrays.toString(generate));
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
