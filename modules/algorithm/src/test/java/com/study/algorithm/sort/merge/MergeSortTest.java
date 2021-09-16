package com.study.algorithm.sort.merge;

import com.study.algorithm.sort.Sorter.Order;
import com.study.algorithm.sort.SorterTest;
import com.study.algorithm.sort.insert.InsertSort;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSortTest extends SorterTest<Number[]> {
  @Test
  void test() {
    final MergeSort mergeSort = new MergeSort();
    final Number[] generate = mergeSort.generate(10);
    System.out.println(Arrays.toString(generate));

    mergeSort.sort(generate);
    System.out.println(Arrays.toString(generate));
    assertSorted(generate);

    mergeSort.sort(generate, Order.DESC);
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
