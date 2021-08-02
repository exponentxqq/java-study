package com.study.leetcode.array.easy;

/**
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 *
 * <p>注意：请不要在超过该数组长度的位置写入元素。
 *
 * <p>要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/duplicate-zeros
 *
 * @number 1089
 * @date 2021/5/21 1:36 PM
 */
public class DuplicateZeros {
  public void duplicateZeros(int[] arr) {
    int len = arr.length;
    int i = 0;
    int lastZeroIdx = 0;
    while (i + 1 < len) {
      if (arr[i] == 0) {
        lastZeroIdx = i;
        len--;
      }
      i++;
    }

    int right = arr.length - 1;
    for (int j = len - 1; j >= 0; j--) {
      if (arr[j] == 0 && j <= lastZeroIdx) {
        arr[right] = 0;
        if (right > j) {
          right--;
          arr[right] = 0;
        }
      } else {
        arr[right] = arr[j];
      }
      right--;
    }
  }
}
