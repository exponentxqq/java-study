package com.study.leetcode.array.easy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SummaryRangesTest {
  @Test
  void test1() {
    final SummaryRanges summaryRanges = new SummaryRanges();

    int[] nums = {0, 1, 2, 4, 5, 7};

    List<String> expect = List.of("0->2", "4->5", "7");

    Assertions.assertEquals(expect, summaryRanges.summaryRanges(nums));
  }

  @Test
  void test2() {
    final SummaryRanges summaryRanges = new SummaryRanges();

    int[] nums = {0, 2, 3, 4, 6, 8, 9};

    List<String> expect = List.of("0", "2->4", "6", "8->9");

    Assertions.assertEquals(expect, summaryRanges.summaryRanges(nums));
  }

  @Test
  void test3() {
    final SummaryRanges summaryRanges = new SummaryRanges();

    int[] nums = {};

    List<String> expect = List.of();

    Assertions.assertEquals(expect, summaryRanges.summaryRanges(nums));
  }

  @Test
  void test4() {
    final SummaryRanges summaryRanges = new SummaryRanges();

    int[] nums = {0};

    List<String> expect = List.of("0");

    Assertions.assertEquals(expect, summaryRanges.summaryRanges(nums));
  }

  @Test
  void test5() {
    final SummaryRanges summaryRanges = new SummaryRanges();

    int[] nums = {-1};

    List<String> expect = List.of("-1");

    Assertions.assertEquals(expect, summaryRanges.summaryRanges(nums));
  }
}
