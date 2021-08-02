package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/6/12 00:19 */
public class ReverseWordsInAStringIIITest {
  @Test
  void test1() {
    ReverseWordsInAStringIII reverseWordsInAStringIII = new ReverseWordsInAStringIII();

    String s = "Let's take LeetCode contest";

    String expected = "s'teL ekat edoCteeL tsetnoc";

    Assertions.assertEquals(expected, reverseWordsInAStringIII.reverseWords(s));
  }
}
