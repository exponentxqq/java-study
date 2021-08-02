package com.study.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * <p>找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * <p>您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 *
 * @number 448
 * @date 2021/4/25 2:37 PM
 */
public class FindAllNumbersDisappearedInArray {
  public List<Integer> findDisappearedNumbers1(int[] nums) {
    List<Integer> res = new ArrayList<>(nums.length - 1);

    int i = 0;
    while (i < nums.length) {
      if (nums[i] == nums[nums[i] - 1]) {
        i++;
        continue;
      }
      if (i + 1 != nums[i]) {
        int temp = nums[i];
        int k = nums[i] - 1;
        nums[i] = nums[k];
        nums[k] = temp;
      } else {
        i++;
      }
    }

    for (int j = 0; j < nums.length; j++) {
      if (nums[j] != j + 1) {
        res.add(j + 1);
      }
    }

    return res;
  }

  public List<Integer> findDisappearedNumbers2(int[] nums) {
    List<Integer> res = new ArrayList<>();

    int n = nums.length;
    for (int num : nums) {
      int x = (num - 1) % n;
      nums[x] += n;
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] <= n) {
        res.add(i + 1);
      }
    }
    return res;
  }
}
