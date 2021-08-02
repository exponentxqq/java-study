package com.study.leetcode.dynamicprogramming.easy;

/**
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 *
 * <p>最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 *
 * <p>选出任一 x，满足 0 < x < N 且 N % x == 0 。 用 N - x 替换黑板上的数字 N 。
 *
 * <p>如果玩家无法执行这些操作，就会输掉游戏。
 *
 * <p>只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 False。假设两个玩家都以最佳状态参与游戏。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/divisor-game
 *
 * @number 1025
 * @date @date 2021/6/4 16:29
 */
public class DivisorGame {
  public boolean divisorGame(int n) {
    return n % 2 == 0;
  }
}
