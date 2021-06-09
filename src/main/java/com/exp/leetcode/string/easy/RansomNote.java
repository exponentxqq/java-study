package com.exp.leetcode.string.easy;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串<br>
 * 判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。<br>
 * 如果可以构成，返回true ；否则返回 false。
 *
 * <p>(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/ransom-note
 *
 * @number 383
 * @date 2021/6/9 16:52
 */
public class RansomNote {
  public boolean canConstruct(String ransomNote, String magazine) {
    String match = ransomNote;
    int findPoint = 0;

    while (findPoint < magazine.length()) {
      char findChar = magazine.charAt(findPoint);
      final int index = match.indexOf(String.valueOf(findChar));
      if (index < 0) {
        findPoint++;
        continue;
      }
      match = match.substring(0, index) + match.substring(index + 1);
      findPoint++;
      if (match.length() == 0) {
        return true;
      }
    }
    return false;
  }
}
