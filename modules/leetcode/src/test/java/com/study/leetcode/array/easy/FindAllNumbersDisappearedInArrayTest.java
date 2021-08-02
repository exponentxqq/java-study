package com.study.leetcode.array.easy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindAllNumbersDisappearedInArrayTest {
  @Test
  void test1() {
    final FindAllNumbersDisappearedInArray findAllNumbersDisappearedInArray =
        new FindAllNumbersDisappearedInArray();

    int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

    List<Integer> expect = List.of(5, 6);

    Assertions.assertEquals(expect, findAllNumbersDisappearedInArray.findDisappearedNumbers2(nums));
  }
}
