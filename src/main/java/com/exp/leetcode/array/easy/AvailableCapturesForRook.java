package com.exp.leetcode.array.easy;

/**
 * 在一个 8 x 8 的棋盘上，有一个白色的车（Rook），用字符 'R' 表示。<br>
 * 棋盘上还可能存在空方块，白色的象（Bishop）以及黑色的卒（pawn），分别用字符 '.'，'B' 和 'p'表示。<br>
 * 不难看出，大写字符表示的是白棋，小写字符表示的是黑棋。
 *
 * <p>车按国际象棋中的规则移动。<br>
 * 东，西，南，北四个基本方向任选其一，然后一直向选定的方向移动，直到满足下列四个条件之一：
 *
 * <p>棋手选择主动停下来。 棋子因到达棋盘的边缘而停下。 <br>
 * 棋子移动到某一方格来捕获位于该方格上敌方（黑色）的卒，停在该方格内。<br>
 * 车不能进入/越过已经放有其他友方棋子（白色的象）的方格，停在友方棋子前。
 *
 * <p>你现在可以控制车移动一次，请你统计有多少敌方的卒处于你的捕获范围内（即，可以被一步捕获的棋子数）。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/available-captures-for-rook
 *
 * @number 999
 * @date 2021/5/20 5:04 PM
 */
public class AvailableCapturesForRook {
  public int numRookCaptures(char[][] board) {
    int[] r = new int[2];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'R') {
          r[0] = i;
          r[1] = j;
          break;
        }
      }
    }

    int count = 0;
    for (int i = r[1] - 1; i >= 0; i--) {
      if (board[r[0]][i] == 'p') {
        count++;
        break;
      } else if (board[r[0]][i] == 'B') {
        break;
      }
    }

    for (int i = r[1] + 1; i < board[r[0]].length; i++) {
      if (board[r[0]][i] == 'p') {
        count++;
        break;
      } else if (board[r[0]][i] == 'B') {
        break;
      }
    }

    for (int i = r[0] - 1; i >= 0; i--) {
      if (board[i][r[1]] == 'p') {
        count++;
        break;
      } else if (board[i][r[1]] == 'B') {
        break;
      }
    }

    for (int i = r[0] + 1; i < board.length; i++) {
      if (board[i][r[1]] == 'p') {
        count++;
        break;
      } else if (board[i][r[1]] == 'B') {
        break;
      }
    }

    return count;
  }
}
