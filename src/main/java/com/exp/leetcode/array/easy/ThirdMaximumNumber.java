package com.exp.leetcode.array.easy;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/third-maximum-number/
 *
 * @number 414
 * @date 2021/4/25 01:21 PM
 */
public class ThirdMaximumNumber {
  public int thirdMax1(int[] nums) {
    int[] maxNums = new int[3];
    boolean[] maxExists = new boolean[3];

    maxNums[0] = Integer.MIN_VALUE;
    maxNums[1] = Integer.MIN_VALUE;
    maxNums[2] = Integer.MIN_VALUE;

    for (int num : nums) {
      for (int j = 0; j < maxNums.length; j++) {
        if (num > maxNums[j]) {
          if (j + 2 < maxNums.length) {
            if (maxNums[j + 1] > maxNums[j + 2]) {
              maxNums[j + 2] = maxNums[j + 1];
              maxExists[j + 2] = true;
            } else if (maxExists[j + 1] && maxNums[j + 1] == maxNums[j + 2]) {
              maxExists[j + 2] = true;
            }
          }

          if (j + 1 < maxNums.length) {
            if (maxNums[j] > maxNums[j + 1]) {
              maxNums[j + 1] = maxNums[j];
              maxExists[j + 1] = true;
            } else if (maxNums[j] == maxNums[j + 1] && maxExists[j]) {
              maxExists[j + 1] = true;
            }
          }

          maxNums[j] = num;
          maxExists[j] = true;
          break;
        } else if (num == maxNums[j]) {
          maxExists[j] = true;
          break;
        }
      }
    }
    return maxExists[2] ? maxNums[2] : maxNums[0];
  }
}
