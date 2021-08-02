package com.study.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。<br>
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * <p>你可以按任意顺序返回答案。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-common-characters
 *
 * @number 1002
 * @date 2021/5/20 7:04 PM
 */
public class FindCommonCharacters {
  public List<String> commonChars(String[] words) {
    int minWordIdx = 0;
    for (int i = 0; i < words.length; i++) {
      if (words[i].length() < words[minWordIdx].length()) {
        minWordIdx = i;
      }
    }

    final String[] split = words[minWordIdx].split("");
    List<String> result = new ArrayList<>();

    for (int i = 0; i < split.length; i++) {
      boolean a = true;
      for (int j = 0; j < words.length; j++) {
        if (j != minWordIdx) {
          if (!words[j].contains(split[i])) {
            a = false;
            break;
          } else {
            words[j] =
                words[j].substring(0, words[j].indexOf(split[i]))
                    + words[j].substring(words[j].indexOf(split[i]) + 1);
          }
        }
      }
      if (a) {
        result.add(split[i]);
      }
    }
    return result;
  }
}
