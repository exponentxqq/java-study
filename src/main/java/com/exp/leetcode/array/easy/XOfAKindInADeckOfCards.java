package com.exp.leetcode.array.easy;

import java.util.Arrays;

/**
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * <p>此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * <p>每组都有 X 张牌。 组内所有的牌上都写着相同的整数。
 *
 * <p>仅当你可选的 X >= 2 时返回 true。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
 *
 * @number 914
 * @date 2021/5/13 10:07 AM
 */
public class XOfAKindInADeckOfCards {
  /** 暴力求解 */
  public boolean hasGroupsSizeX(int[] deck) {
    if (deck.length < 2) {
      return false;
    }
    Arrays.sort(deck);

    for (int gap = 2; gap < Math.floor(deck.length + 1); gap++) {
      boolean t = true;
      int i = gap;
      for (; i <= deck.length; i += gap) {
        for (int j = i - gap; j <= i - 1; j++) {
          if (deck[i - 1] != deck[j]) {
            t = false;
            break;
          }
        }
        if (!t) {
          break;
        }
      }
      if (t && i - gap >= deck.length) {
        return true;
      }
    }

    return false;
  }
}
