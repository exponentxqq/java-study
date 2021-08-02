package com.study.leetcode.array.easy;

import java.util.Arrays;

/**
 * 给你一个以行程长度编码压缩的整数列表nums。
 *
 * <p>考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]]<br>
 * （其中i >= 0），每一对都表示解压后子列表中有freq个值为val的元素，<br>
 * 你需要从左到右连接所有子列表以生成解压后的列表。<br>
 *
 * <p>请你返回解压后的列表。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/decompress-run-length-encoded-list
 *
 * @number 1313
 * @date 2021/5/22 10:49 PM
 */
public class DecompressRunLengthEncodedList {
  public int[] decompressRLElist(int[] nums) {
    int[] result = new int[nums.length * 100 / 2];

    int point = 0;
    for (int i = 0; i < nums.length; i += 2) {
      for (int j = 0; j < nums[i]; j++) {
        result[point++] = nums[i + 1];
      }
    }

    return Arrays.stream(result).limit(point).toArray();
  }
}
