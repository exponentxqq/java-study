package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/6/12 15:02 */
public class RobotReturnToOriginTest {
  @Test
  void test1() {
    RobotReturnToOrigin robotReturnToOrigin = new RobotReturnToOrigin();

    String moves = "UD";

    boolean expected = true;

    Assertions.assertEquals(expected, robotReturnToOrigin.judgeCircle(moves));
  }

  @Test
  void test2() {
    RobotReturnToOrigin robotReturnToOrigin = new RobotReturnToOrigin();

    String moves = "LL";

    boolean expected = false;

    Assertions.assertEquals(expected, robotReturnToOrigin.judgeCircle(moves));
  }
}
