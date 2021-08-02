package com.study.leetcode.dynamicprogramming.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThreeStepsProblemLcciTest {
  @Test
  void test1() {
    final ThreeStepsProblemLcci threeStepsProblemLcci = new ThreeStepsProblemLcci();

    int n = 3;

    int expected = 4;

    Assertions.assertEquals(expected, threeStepsProblemLcci.waysToStep(n));
  }

  @Test
  void test2() {
    final ThreeStepsProblemLcci threeStepsProblemLcci = new ThreeStepsProblemLcci();

    int n = 5;

    int expected = 13;

    Assertions.assertEquals(expected, threeStepsProblemLcci.waysToStep(n));
  }

  @Test
  void test3() {
    final ThreeStepsProblemLcci threeStepsProblemLcci = new ThreeStepsProblemLcci();

    int n = 61;

    int expected = 752119970;

    Assertions.assertEquals(expected, threeStepsProblemLcci.waysToStep(n));
  }
}
