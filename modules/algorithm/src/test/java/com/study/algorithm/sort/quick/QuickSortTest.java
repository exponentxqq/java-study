package com.study.algorithm.sort.quick;

import com.study.algorithm.sort.Sorter.Order;
import com.study.algorithm.sort.SorterTest;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuickSortTest extends SorterTest<Number[]> {
  @Test
  void test() {
    final QuickSort quickSort = new QuickSort();
    final Number[] generate = quickSort.generate(10);
    System.out.println(Arrays.toString(generate));

    quickSort.sort(generate);
    System.out.println(Arrays.toString(generate));
    assertSorted(generate);

    // quickSort.sort(generate, Order.DESC);
    // System.out.println(Arrays.toString(generate));
    // assertSorted(generate, Order.DESC);
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
