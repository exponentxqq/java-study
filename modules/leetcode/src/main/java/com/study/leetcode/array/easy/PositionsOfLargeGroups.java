package com.study.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 *
 * <p>例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * <p>分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。<br>
 * 上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 *
 * <p>我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 *
 * <p>找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 *
 * @number 830
 * @date 2021/5/11 4:17 PM
 */
public class PositionsOfLargeGroups {
  public List<List<Integer>> largeGroupPositions(String s) {
    List<List<Integer>> result = new ArrayList<>();
    final String[] split = s.split("");
    int start = 0;
    for (int i = 1; i < split.length; i++) {
      if (!split[i].equals(split[start])) {
        if (i - start > 2) {
          result.add(List.of(start, i - 1));
        }
        start = i;
      }
    }

    if (start != split.length - 1 && split.length - start > 2) {
      result.add(List.of(start, split.length - 1));
    }
    return result;
  }
}
