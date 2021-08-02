package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/6/12 15:40 */
public class ToLowerCaseTest {
  @Test
  void test1() {
    ToLowerCase toLowerCase = new ToLowerCase();

    String s = "Hello";

    String expected = "hello";

    Assertions.assertEquals(expected, toLowerCase.toLowerCase(s));
  }

  @Test
  void test2() {
    ToLowerCase toLowerCase = new ToLowerCase();

    String s = "here";

    String expected = "here";

    Assertions.assertEquals(expected, toLowerCase.toLowerCase(s));
  }

  @Test
  void test3() {
    ToLowerCase toLowerCase = new ToLowerCase();

    String s = "LOVELY";

    String expected = "lovely";

    Assertions.assertEquals(expected, toLowerCase.toLowerCase(s));
  }

  @Test
  void test4() {
    ToLowerCase toLowerCase = new ToLowerCase();

    String s = "al&phaBET";

    String expected = "al&phabet";

    Assertions.assertEquals(expected, toLowerCase.toLowerCase(s));
  }
}
