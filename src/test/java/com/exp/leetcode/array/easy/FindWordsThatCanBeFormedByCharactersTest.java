package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindWordsThatCanBeFormedByCharactersTest {
  @Test
  void test() {
    final char c = "abcd".charAt(2);
    Assertions.assertTrue(true);
  }

  @Test
  void test1() {
    final FindWordsThatCanBeFormedByCharacters findWordsThatCanBeFormedByCharacters =
        new FindWordsThatCanBeFormedByCharacters();

    String[] words = {"cat", "bt", "hat", "tree"};
    String chars = "atach";

    int expected = 6;

    Assertions.assertEquals(
        expected, findWordsThatCanBeFormedByCharacters.countCharacters(words, chars));
  }

  @Test
  void test2() {
    final FindWordsThatCanBeFormedByCharacters findWordsThatCanBeFormedByCharacters =
        new FindWordsThatCanBeFormedByCharacters();

    String[] words = {"hello", "world", "leetcode"};
    String chars = "welldonehoneyr";

    int expected = 10;

    Assertions.assertEquals(
        expected, findWordsThatCanBeFormedByCharacters.countCharacters(words, chars));
  }

  @Test
  void test3() {
    final FindWordsThatCanBeFormedByCharacters findWordsThatCanBeFormedByCharacters =
        new FindWordsThatCanBeFormedByCharacters();
    String[] words = {
      "dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin",
      "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb",
      "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl",
      "boygirdlggnh",
      "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx",
      "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop",
      "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx",
      "juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr",
      "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo",
      "oxgaskztzroxuntiwlfyufddl",
      "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp",
      "qnagrpfzlyrouolqquytwnwnsqnmuzphne",
      "eeilfdaookieawrrbvtnqfzcricvhpiv",
      "sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz",
      "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue",
      "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv",
      "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo",
      "teyygdmmyadppuopvqdodaczob",
      "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs",
      "qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"
    };
    String chars = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";

    int expected = 0;

    Assertions.assertEquals(
        expected, findWordsThatCanBeFormedByCharacters.countCharacters(words, chars));
  }
}
