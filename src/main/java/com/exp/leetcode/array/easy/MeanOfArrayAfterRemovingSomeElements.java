package com.exp.leetcode.array.easy;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
 *
 * <p>与 标准答案 误差在 10^-5 的结果都被视为正确结果。
 *
 * <p>来源：力扣（LeetCode）链接：https://leetcode-cn.com/problems/mean-of-array-after-removing-some-elements/
 *
 * @number 1619
 * @date 2021/5/21 2:57 PM
 */
public class MeanOfArrayAfterRemovingSomeElements {
  public double trimMean(int[] arr) {
    final double trimLen = Math.ceil(arr.length * 0.05);
    Arrays.sort(arr);

    double sum = 0;
    for (double i = trimLen; i < arr.length - trimLen; i++) {
      sum += arr[(int) i];
    }

    return sum / (arr.length - trimLen * 2);
  }
}
