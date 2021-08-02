package com.study.leetcode.array.easy;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * <p>对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * <p>你可以返回任何满足上述条件的数组作为答案。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 *
 * @number 922
 * @date 2021/5/20 2:15 PM
 */
public class SortArrayByParity2 {
  public int[] sortArrayByParityII(int[] nums) {
    int[] result = new int[nums.length];

    int evenPoint = 0;
    int oddPoint = 1;

    for (int num : nums) {
      if (num % 2 == 0) {
        result[evenPoint] = num;
        evenPoint += 2;
      } else {
        result[oddPoint] = num;
        oddPoint += 2;
      }
    }
    return result;
  }
}
