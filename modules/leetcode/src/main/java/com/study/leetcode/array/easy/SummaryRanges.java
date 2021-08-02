package com.study.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * <p>返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。<br>
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * <p>列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * <p>"a->b" ，如果 a != b "a" ，如果 a == b
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/summary-ranges
 *
 * @number 228
 * @date 2021/5/10 1:04 PM
 */
public class SummaryRanges {
  public List<String> summaryRanges(int[] nums) {
    List<String> list = new ArrayList<>();

    if (nums.length == 0) {
      return list;
    }

    int start = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - 1 != nums[i - 1]) {
        if (start == nums[i - 1]) {
          list.add(String.valueOf(start));
        } else {
          list.add(start + "->" + nums[i - 1]);
        }
        start = nums[i];
      }
    }

    if (nums[nums.length - 1] != start) {
      list.add(start + "->" + nums[nums.length - 1]);
    } else {
      list.add(String.valueOf(start));
    }

    return list;
  }
}
