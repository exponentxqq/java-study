package com.study.leetcode.string.medium;

/**
 *
 *
 * <h2>Z字形变换
 *
 * <p>将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * <p>比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * <pre>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * </pre>
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * <pre>
 * P     I     N
 * A   L S   I G
 * Y A   H R
 * P     I
 * </pre>
 *
 * <p>PINALSIGYAHRPI
 *
 * @number 5
 * @date 2024/1/25 15:01
 */
public class ZShapedTransformation {
  public String convert(String s, int numRows) {
    if (s.length() < 3 || numRows == 1) {
      return s;
    }
    // 一个Z字为一块

    // 获取总块数
    int numSections = 2 * numRows - 2;
    // 没一块的列数
    int numSectionCols = numRows - 1;
    // 总列数
    int numCols = (int) Math.ceil(numSectionCols * s.length() * 1f / numSections);

    Character[][] a = new Character[numRows][numCols];
    for (int i = 0; i < s.length(); i++) {
      int section = i / numSections;
      int inSectionIdx = i - section * numSections;
      int col =
          (inSectionIdx < numRows ? 0 : inSectionIdx - numRows + 1) + numSectionCols * section;
      int row = inSectionIdx < numRows ? inSectionIdx : numRows - (inSectionIdx - numRows + 1) - 1;
      a[row][col] = s.charAt(i);
    }
    StringBuilder result = new StringBuilder();
    for (Character[] characters : a) {
      for (Character character : characters) {
        if (character != null) {
          result.append(character);
        }
      }
    }
    return result.toString();
  }
}
