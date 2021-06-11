package com.exp.leetcode.string.easy;

/**
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 *
 * <p>'A' : Absent，缺勤 'L' : Late，迟到 'P' : Present，到场<br>
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 *
 * <p>你需要根据这个学生的出勤记录判断他是否会被奖赏。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/student-attendance-record-i
 *
 * @number 551
 * @date 2021/6/12 00:02
 */
public class StudentAttendanceRecordI {
  public boolean checkRecord(String s) {
    boolean twoL = false;
    int countA = 0;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if ('A' == ch) {
        countA++;
      } else if ('L' == ch) {
        if (i + 2 < s.length() && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
          twoL = true;
        }
      }
    }

    return countA < 2 && !twoL;
  }
}
