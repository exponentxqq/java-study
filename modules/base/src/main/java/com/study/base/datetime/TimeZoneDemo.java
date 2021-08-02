package com.study.base.datetime;

import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeZoneDemo {
  public static void main(String[] args) {
    final TimeZone tzDefault = TimeZone.getDefault(); // 当前时区
    final TimeZone tzGmt9 = TimeZone.getTimeZone("GMT+09:00"); // GMT+9:00时区
    final TimeZone tzNewYork = TimeZone.getTimeZone("America/New_York"); // 纽约时区
    System.out.println(tzDefault.getID());
    System.out.println(tzGmt9.getID());
    System.out.println(tzNewYork.getID());

    transferTZ();

    final String[] timeZones = TimeZone.getAvailableIDs();
    System.out.println(Arrays.toString(timeZones));
  }

  private static void transferTZ() {
    Calendar calendar = Calendar.getInstance();
    System.out.println("local hour: " + calendar.get(Calendar.HOUR_OF_DAY));
    System.out.println("local timezone: " + calendar.getTimeZone().getID());

    // calendar.clear();
    calendar.setTimeZone(TimeZone.getTimeZone("America/New_York"));
    System.out.println("transfer hour: " + calendar.get(Calendar.HOUR_OF_DAY));
    System.out.println("transfer timezone: " + calendar.getTimeZone().getID());
  }
}
