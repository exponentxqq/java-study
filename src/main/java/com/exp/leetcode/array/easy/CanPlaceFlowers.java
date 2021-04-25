package com.exp.leetcode.array.easy;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。<br>
 * 可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * <p>给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。<br>
 * 另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回true ，不能则返回 false。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/can-place-flowers
 *
 * @number 605
 * @date 2021/4/25 6:42 PM
 */
public class CanPlaceFlowers {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int count = 0;

    if (flowerbed.length < 2) {
      if (flowerbed[0] == 0) {
        return 1 >= n;
      }
    }

    if (flowerbed[0] == 0 && flowerbed[1] == 0) {
      flowerbed[0] = 1;
      count++;
    }

    if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
      flowerbed[flowerbed.length - 1] = 1;
      count++;
    }

    for (int i = 1; i < flowerbed.length - 1; i++) {
      if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
        count++;
        flowerbed[i] = 1;
      }
    }

    return count >= n;
  }
}
