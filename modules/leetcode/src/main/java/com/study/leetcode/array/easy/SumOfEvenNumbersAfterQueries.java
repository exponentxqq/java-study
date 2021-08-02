package com.study.leetcode.array.easy;

/**
 * 给出一个整数数组 A 和一个查询数组 queries。
 *
 * <p>对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，<br>
 * 我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 *
 * <p>（此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 *
 * <p>返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries
 *
 * @number 985
 * @date 2021/5/20 3:51 PM
 */
public class SumOfEvenNumbersAfterQueries {
  public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
    int[] answer = new int[nums.length];
    int evenSum = sumEven(nums);

    for (int i = 0; i < queries.length; i++) {
      int val = queries[i][0];
      int index = queries[i][1];

      boolean isEven = nums[index] % 2 == 0;
      int source = nums[index];

      nums[index] = nums[index] + val;
      if (nums[index] % 2 == 0) {
        evenSum = isEven ? evenSum + val : evenSum + nums[index];
      } else {
        evenSum = isEven ? evenSum - source : evenSum;
      }
      answer[i] = evenSum;
    }
    return answer;
  }

  private int sumEven(int[] nums) {
    int result = 0;
    for (int num : nums) {
      if (num % 2 == 0) {
        result += num;
      }
    }
    return result;
  }
}
