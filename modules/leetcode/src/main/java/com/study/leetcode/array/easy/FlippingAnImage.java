package com.study.leetcode.array.easy;

/**
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * <p>水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * <p>反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/flipping-an-image
 *
 * @number 832
 * @date 2021/5/11 4:37 PM
 */
public class FlippingAnImage {
  public int[][] flipAndInvertImage(int[][] image) {
    int[][] result = new int[image.length][image[0].length];
    for (int i = 0; i < image.length; i++) {
      for (int j = image[i].length - 1; j >= 0; j--) {
        result[i][image[i].length - 1 - j] = image[i][j] == 1 ? 0 : 1;
      }
    }
    return result;
  }
}
