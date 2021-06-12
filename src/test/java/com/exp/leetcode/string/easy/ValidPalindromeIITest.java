package com.exp.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/6/12 15:07 */
public class ValidPalindromeIITest {
  @Test
  void test1() {
    ValidPalindromeII validPalindromeII = new ValidPalindromeII();

    String s = "aba";

    boolean expected = true;

    Assertions.assertEquals(expected, validPalindromeII.validPalindrome(s));
  }

  @Test
  void test2() {
    ValidPalindromeII validPalindromeII = new ValidPalindromeII();

    String s = "abca";

    boolean expected = true;

    Assertions.assertEquals(expected, validPalindromeII.validPalindrome(s));
  }

  @Test
  void test3() {
    ValidPalindromeII validPalindromeII = new ValidPalindromeII();

    String s = "abaacaabaaaba";

    boolean expected = false;

    Assertions.assertEquals(expected, validPalindromeII.validPalindrome(s));
  }

  @Test
  void test4() {
    ValidPalindromeII validPalindromeII = new ValidPalindromeII();

    String s = "vfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfv";

    boolean expected = true;

    Assertions.assertEquals(expected, validPalindromeII.validPalindrome(s));
  }
}
