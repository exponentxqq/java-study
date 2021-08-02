package com.study.leetcode.string.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 *
 * <p>为了方便，所有26个英文字母对应摩尔斯密码表如下：
 *
 * <p>[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 *
 * <p>给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + ".-" + "-..."
 * 字符串的结合)。我们将这样一个连接过程称作单词翻译。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/unique-morse-code-words
 *
 * @number 804
 * @date 2021/6/15 16:24
 */
public class UniqueMorseCodeWords {
  public int uniqueMorseRepresentations(String[] words) {
    List<String> morses =
        List.of(
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..");

    Map<String, Boolean> resultMap = new HashMap<>();

    for (int i = 0; i < words.length; i++) {
      String morseWord = "";
      for (int j = 0; j < words[i].length(); j++) {
        morseWord += morses.get(words[i].charAt(j) - 'a');
      }
      resultMap.put(morseWord, true);
    }
    return resultMap.size();
  }
}
