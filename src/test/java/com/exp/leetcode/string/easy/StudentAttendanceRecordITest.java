package com.exp.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/6/12 00:02 */
public class StudentAttendanceRecordITest {
  @Test
  void test1() {
    StudentAttendanceRecordI studentAttendanceRecordI = new StudentAttendanceRecordI();

    String s = "PPALLP";

    boolean expected = true;

    Assertions.assertEquals(expected, studentAttendanceRecordI.checkRecord(s));
  }

  @Test
  void test2() {
    StudentAttendanceRecordI studentAttendanceRecordI = new StudentAttendanceRecordI();

    String s = "PPALLL";

    boolean expected = false;

    Assertions.assertEquals(expected, studentAttendanceRecordI.checkRecord(s));
  }
}
