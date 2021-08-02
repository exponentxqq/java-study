package com.study.leetcode.string.easy;

/**
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 *
 * <p>我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * <p>全部字母都是大写，比如"USA"。 <br>
 * 单词中所有字母都不是大写，比如"leetcode"。<br>
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 *
 * <p>否则，我们定义这个单词没有正确使用大写字母。
 *
 * <p>注意: 输入是由大写和小写拉丁字母组成的非空单词。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/detect-capital
 *
 * @number 520
 * @date 2021/6/10 10:04
 */
public class DetectCapital {
  public boolean detectCapitalUse(String word) {
    boolean firstIsUpper = word.charAt(0) < 'a';

    boolean preIsUpper = false;
    for (int i = 1; i < word.length(); i++) {
      boolean isUpper = word.charAt(i) < 'a';
      if (!firstIsUpper && isUpper) {
        return false;
      }
      if (i > 1) {
        if (preIsUpper && !isUpper) {
          return false;
        }
        if (!preIsUpper && isUpper) {
          return false;
        }
      }
      preIsUpper = isUpper;
    }
    return true;
  }
}
