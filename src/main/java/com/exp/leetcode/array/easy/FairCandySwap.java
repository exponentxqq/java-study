package com.exp.leetcode.array.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 *
 * <p>因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * <p>返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * <p>如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/fair-candy-swap
 *
 * @number 888
 * @date 2021/5/11 4:53 PM
 */
public class FairCandySwap {
  public int[] fairCandySwap(int[] A, int[] B) {
    int sumA = Arrays.stream(A).sum();
    int sumB = Arrays.stream(B).sum();
    int delta = (sumA - sumB) / 2;
    Set<Integer> set = Arrays.stream(A).boxed().collect(Collectors.toSet());

    for (int i : B) {
      if (set.contains(i + delta)) {
        return new int[] {i + delta, i};
      }
    }
    return new int[] {};
  }
}
