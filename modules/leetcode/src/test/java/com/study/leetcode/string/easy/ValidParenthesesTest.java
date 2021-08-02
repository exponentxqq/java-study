package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/5/26 9:09 PM */
public class ValidParenthesesTest {
  @Test
  void test1() {
    ValidParentheses validParentheses = new ValidParentheses();

    String s = "()";

    boolean expected = true;

    Assertions.assertEquals(expected, validParentheses.isValid(s));
  }

  @Test
  void test2() {
    ValidParentheses validParentheses = new ValidParentheses();

    String s = "()[]{}";

    boolean expected = true;

    Assertions.assertEquals(expected, validParentheses.isValid(s));
  }

  @Test
  void test3() {
    ValidParentheses validParentheses = new ValidParentheses();

    String s = "(]";

    boolean expected = false;

    Assertions.assertEquals(expected, validParentheses.isValid(s));
  }

  @Test
  void test4() {
    ValidParentheses validParentheses = new ValidParentheses();

    String s = "([)]";

    boolean expected = false;

    Assertions.assertEquals(expected, validParentheses.isValid(s));
  }

  @Test
  void test5() {
    ValidParentheses validParentheses = new ValidParentheses();

    String s = "{[]}";

    boolean expected = true;

    Assertions.assertEquals(expected, validParentheses.isValid(s));
  }

  @Test
  void test6() {
    ValidParentheses validParentheses = new ValidParentheses();

    String s = "{";

    boolean expected = false;

    Assertions.assertEquals(expected, validParentheses.isValid(s));
  }

  @Test
  void test7() {
    ValidParentheses validParentheses = new ValidParentheses();

    String s = "{{";

    boolean expected = false;

    Assertions.assertEquals(expected, validParentheses.isValid(s));
  }
}
