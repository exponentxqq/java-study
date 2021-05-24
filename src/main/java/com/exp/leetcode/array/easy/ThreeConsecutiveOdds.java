package com.exp.leetcode.array.easy;

/**
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：<br>
 * 如果存在，请返回 true ；否则，返回 false 。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/three-consecutive-odds/
 *
 * @number 1550
 * @date 2021/5/24 11:59 PM
 */
public class ThreeConsecutiveOdds {
  public boolean threeConsecutiveOdds1(int[] arr) {
    for (int i = 0; i < arr.length - 2; i++) {
      if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
        return true;
      }
    }
    return false;
  }

  public boolean threeConsecutiveOdds(int[] arr) {
    int count = 0;
    for (int j : arr) {
      if (j % 2 != 0) {
        count++;
        if (count >= 3) {
          return true;
        }
      } else {
        count = 0;
      }
    }
    return false;
  }
}
