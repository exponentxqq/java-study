package com.exp.leetcode.array.easy;

/**
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 *
 * <p>输入为三个整数：day、month 和year，分别表示日、月、年。
 *
 * <p>您返回的结果必须是这几个值中的一个<br>
 * {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/day-of-the-week
 *
 * @number 1185
 * @date 2021/5/24 11:37 PM
 */
public class DayOfTheWeek {
  public String dayOfTheWeek(int day, int month, int year) {
    String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    int baseIdx = 5;
    // 1971年1月1日为周五
    int dayCountOfYears = 0;
    for (int i = 1971; i < year; i++) {
      if (i % 100 == 0) {
        if (i % 400 == 0) {
          dayCountOfYears += 366;
        }
      } else if (i % 4 == 0) {
        dayCountOfYears += 366;
      } else {
        dayCountOfYears += 365;
      }
    }

    int dayCountOfMonths = 0;
    for (int i = 1; i < month; i++) {
      switch (i) {
        case 2:
          if ((year % 100 == 0 && year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
            dayCountOfMonths += 29;
          } else {
            dayCountOfMonths += 28;
          }
          break;
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
          dayCountOfMonths += 31;
          break;
        default:
          dayCountOfMonths += 30;
          break;
      }
    }

    int allDay = day + dayCountOfMonths + dayCountOfYears - 1;
    int gap = allDay % 7;
    int descIdx = gap + baseIdx;

    return weeks[descIdx >= weeks.length ? descIdx - weeks.length : descIdx];
  }
}
