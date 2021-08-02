package com.study.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定由若干 0 和 1 组成的数组 A。<br>
 * 我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 *
 * <p>返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/binary-prefix-divisible-by-5
 *
 * @number 1018
 * @date 2021/5/21 10:25 AM
 */
public class BinaryPrefixDivisibleBy5 {
  public List<Boolean> prefixesDivBy5(int[] nums) {
    final ArrayList<Boolean> result = new ArrayList<>();
    int prefix = 0;
    for (int num : nums) {
      // 不存余数的话prefix可能会超过最大整数
      prefix = ((prefix << 1) + num) % 5;
      result.add(prefix == 0);
    }
    return result;
  }
}
