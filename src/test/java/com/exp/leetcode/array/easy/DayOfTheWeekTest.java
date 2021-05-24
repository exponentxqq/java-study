package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/5/24 11:38 PM */
public class DayOfTheWeekTest {
  @Test
  void test1() {
    DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();

    int day = 31;
    int month = 8;
    int year = 2019;

    String expected = "Saturday";

    Assertions.assertEquals(expected, dayOfTheWeek.dayOfTheWeek(day, month, year));
  }

  @Test
  void test2() {
    DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();

    int day = 18;
    int month = 7;
    int year = 1999;

    String expected = "Sunday";

    Assertions.assertEquals(expected, dayOfTheWeek.dayOfTheWeek(day, month, year));
  }

  @Test
  void test3() {
    DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();

    int day = 15;
    int month = 8;
    int year = 1993;

    String expected = "Sunday";

    Assertions.assertEquals(expected, dayOfTheWeek.dayOfTheWeek(day, month, year));
  }
}
