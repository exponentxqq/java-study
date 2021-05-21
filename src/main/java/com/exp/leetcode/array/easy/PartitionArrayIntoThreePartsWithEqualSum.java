package com.exp.leetcode.array.easy;

/**
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * <p>形式上，如果可以找出索引 i+1 < j 且满足<br>
 * A[0]+A[1]+...+A[i] == A[i+1]+A[i+2]+...+A[j-1] == A[j]+A[j-1]+...+A[A.length - 1]<br>
 * 就可以将数组三等分。
 *
 * <p>来源：力扣（LeetCode）链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 *
 * @number 1013
 * @date 2021/5/20 7:25 PM
 */
public class PartitionArrayIntoThreePartsWithEqualSum {
  public boolean canThreePartsEqualSum(int[] arr) {

    int sum = 0;
    for (int j : arr) {
      sum += j;
    }
    int target = sum / 3;

    int left = 0;
    int right = arr.length - 1;

    int leftSum = 0;
    int rightSum = 0;

    // left == 0 || right == arr.length - 1是为了避免target==0的情况下，指针不移动
    while ((leftSum != target || rightSum != target || left == 0 || right == arr.length - 1)
        && left < right) {
      if (leftSum != target || left == 0) {
        leftSum += arr[left];
        left++;
      }
      if (rightSum != target || right == arr.length - 1) {
        rightSum += arr[right];
        right--;
      }
    }

    if (left > right || leftSum != rightSum) {
      return false;
    }

    int centerSum = 0;
    for (int i = left; i <= right; i++) {
      centerSum += arr[i];
    }
    return centerSum == target;
  }
}
