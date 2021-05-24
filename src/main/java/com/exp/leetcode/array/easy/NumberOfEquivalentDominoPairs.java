package com.exp.leetcode.array.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个由一些多米诺骨牌组成的列表dominoes。
 *
 * <p>如果其中某一张多米诺骨牌可以通过旋转 0度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * <p>形式上，dominoes[i] = [a, b]和dominoes[j] = [c, d]等价的前提是a==c且b==d，或是a==d 且b==c。
 *
 * <p>在0 <= i < j < dominoes.length的前提下<br>
 * 找出满足dominoes[i] 和dominoes[j]等价的骨牌对 (i, j) 的数量。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 *
 * @number 1128
 * @date 2021/5/22 3:31 PM
 */
public class NumberOfEquivalentDominoPairs {
  /** 暴力求解 */
  public int numEquivDominoPairs1(int[][] dominoes) {
    int count = 0;
    for (int i = 0; i < dominoes.length; i++) {
      for (int j = i + 1; j < dominoes.length; j++) {
        if ((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1])
            || (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0])) {
          count++;
        }
      }
    }
    return count;
  }

  public int numEquivDominoPairs(int[][] dominoes) {
    Map<Integer, Integer> countMap = new HashMap<>();
    Map<Integer, Boolean> used = new HashMap<>();
    for (int i = 0; i < dominoes.length; i++) {
      if (!countMap.containsKey(i)) {
        countMap.put(i, 0);
      }
      if (used.containsKey(i)) {
        continue;
      }
      for (int j = i + 1; j < dominoes.length; j++) {
        if (!used.containsKey(j)) {
          if ((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1])
              || (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0])) {
            used.put(j, true);
            countMap.put(i, countMap.get(i) + 1);
          }
        }
      }
    }

    int count = 0;
    for (int i = 0; i < countMap.size(); i++) {
      if (countMap.get(i) > 0) {
        long n = 1;
        for (int j = countMap.get(i); j <= countMap.get(i) + 1; j++) {
          n *= j;
        }
        count += (int) (n / 2);
      }
    }

    return count;
  }
}
