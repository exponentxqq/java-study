package com.exp.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoatLatinTest {
  @Test
  void test1() {
    final GoatLatin goatLatin = new GoatLatin();

    String sentence = "I speak Goat Latin";

    String expected = "Imaa peaksmaaa oatGmaaaa atinLmaaaaa";

    Assertions.assertEquals(expected, goatLatin.toGoatLatin(sentence));
  }

  @Test
  void test2() {
    final GoatLatin goatLatin = new GoatLatin();

    String sentence = "Each word consists of lowercase and uppercase letters only";

    String expected =
        "Eachmaa ordwmaaa onsistscmaaaa ofmaaaaa owercaselmaaaaaa andmaaaaaaa uppercasemaaaaaaaa etterslmaaaaaaaaa onlymaaaaaaaaaa";

    Assertions.assertEquals(expected, goatLatin.toGoatLatin(sentence));
  }
}
