package com.exp.leetcode.array.easy;

/**
 * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入)
 * ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/image-smoother <br>
 * <code>
 *   输入:
 * [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * 输出:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 * </code>
 *
 * @number 661
 * @date 2021/5/8 10:22 AM
 */
public class ImageSmoother {
  public int[][] imageSmoother(int[][] img) {
    int[][] result = new int[img.length][img[0].length];
    for (int i = 0; i < img.length; i++) {
      for (int j = 0; j < img[i].length; j++) {
        int sum = img[i][j];
        int count = 1;
        // current line
        if (j - 1 >= 0) {
          sum += img[i][j - 1];
          count++;
        }
        if (j + 1 < img[i].length) {
          sum += img[i][j + 1];
          count++;
        }
        // pre line
        if (i - 1 >= 0) {
          sum += img[i - 1][j];
          count++;
          if (j - 1 >= 0) {
            sum += img[i - 1][j - 1];
            count++;
          }
          if (j + 1 < img[i - 1].length) {
            sum += img[i - 1][j + 1];
            count++;
          }
        }

        // next line
        if (i + 1 < img.length) {
          if (j - 1 >= 0) {
            sum += img[i + 1][j - 1];
            count++;
          }
          if (j + 1 < img[i + 1].length) {
            sum += img[i + 1][j + 1];
            count++;
          }
          sum += img[i + 1][j];
          count++;
        }

        result[i][j] = sum / count;
      }
    }
    return result;
  }
}
