package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseStringIITest {
  @Test
  void test() {
    final double floor = Math.ceil(3 / (double) 10);
    Assertions.assertTrue(true);
  }

  @Test
  void test1() {
    final ReverseStringII reverseStringII = new ReverseStringII();

    String s = "abcdefg";
    int k = 2;

    String expected = "bacdfeg";

    Assertions.assertEquals(expected, reverseStringII.reverseStr(s, k));
  }

  @Test
  void test2() {
    final ReverseStringII reverseStringII = new ReverseStringII();

    String s = "abcd";
    int k = 4;

    String expected = "dcba";

    Assertions.assertEquals(expected, reverseStringII.reverseStr(s, k));
  }

  @Test
  void test3() {
    final ReverseStringII reverseStringII = new ReverseStringII();

    String s = "abcdefg";
    int k = 8;

    String expected = "gfedcba";

    Assertions.assertEquals(expected, reverseStringII.reverseStr(s, k));
  }

  @Test
  void test4() {
    final ReverseStringII reverseStringII = new ReverseStringII();

    String s =
        "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
    int k = 39;

    String expected =
        "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqllgsqddebemjanqcqnfkjmi";

    Assertions.assertEquals(expected, reverseStringII.reverseStr(s, k));
  }

  @Test
  void test5() {
    final ReverseStringII reverseStringII = new ReverseStringII();

    String s = "abcdefghij";
    int k = 4;

    String expected = "dcbaefghji";

    Assertions.assertEquals(expected, reverseStringII.reverseStr(s, k));
  }

  @Test
  void test6() {
    final ReverseStringII reverseStringII = new ReverseStringII();

    String s = "abcd";
    int k = 3;

    String expected = "cbad";

    Assertions.assertEquals(expected, reverseStringII.reverseStr(s, k));
  }

  @Test
  void test7() {
    final ReverseStringII reverseStringII = new ReverseStringII();

    String s = "krmyfhfursubewlkgatzosfxc";
    int k = 5;

    String expected = "fymrkhfurslwebukgatzcxfso";
    // "jlnnxsetgcpsbhsfymrk hfursyissjnsocgdhgfx
    // cxfsogsgqsnvckjvnskkchphtifmmfrpbyfztagktxrlvugsaphqzxllwebu"

    Assertions.assertEquals(expected, reverseStringII.reverseStr(s, k));
  }
}
