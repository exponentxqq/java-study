package com.study.base.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * 使用LocalDateTime可以非常方便地对日期和时间进行加减，或者调整日期和时间，它总是返回新对象；
 *
 * <p>使用isBefore()和isAfter()可以判断日期和时间的先后；
 *
 * <p>使用Duration和Period可以表示两个日期和时间的“区间间隔”。
 */
public class LocalDateDemo {
  public static void main(String[] args) {
    baseUsage();
    format();
    calc();
    with();
    crontab();
    compare();
    duration();
  }

  private static void baseUsage() {
    final LocalDate nowDate = LocalDate.now();
    final LocalTime nowTime = LocalTime.now();
    final LocalDateTime nowDatetime = LocalDateTime.now();
    System.out.println(nowDate);
    System.out.println(nowTime);
    System.out.println(nowDatetime);

    final LocalDateTime nowDatetime1 = LocalDateTime.now();
    final LocalDate nowDate1 = nowDatetime1.toLocalDate();
    final LocalTime nowTime1 = nowDatetime1.toLocalTime();
    System.out.println(nowDate1);
    System.out.println(nowTime1);
    System.out.println(nowDatetime1);

    final LocalDateTime datetime = LocalDateTime.of(2019, 11, 30, 15, 16, 17);
    LocalDate date = LocalDate.of(2019, 11, 30);
    LocalTime time = LocalTime.of(15, 16, 17);
    final LocalDateTime datetime1 = LocalDateTime.of(date, time);
    System.out.println(datetime);
    System.out.println(datetime1);

    final LocalDateTime parsedDatetime = LocalDateTime.parse("2019-11-19T15:16:17");
    final LocalDate parsedDate = LocalDate.parse("2019-11-19");
    final LocalTime parsedTime = LocalTime.parse("15:16:17");
    System.out.println(parsedDate);
    System.out.println(parsedTime);
    System.out.println(parsedDatetime);
  }

  private static void format() {
    System.out.println("-----------format-----------------");
    final LocalDateTime parsedDatetime = LocalDateTime.parse("2019-11-19T15:16:17");
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    final String formatted = formatter.format(parsedDatetime);
    System.out.println("format: " + formatter.format(parsedDatetime));
    final LocalDateTime formatterDatetime = LocalDateTime.parse(formatted, formatter);
    System.out.println("parsed formatted: " + formatterDatetime);
  }

  private static void calc() {
    System.out.println("---------------calc--------------");
    LocalDateTime datetime = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
    System.out.println(datetime);
    // +5天，-3小时
    final LocalDateTime datetime1 = datetime.plusDays(5).minusHours(3);
    System.out.println(datetime1);
    // -1月
    final LocalDateTime datetime2 = datetime1.minusMonths(1);
    System.out.println(datetime2);
  }

  private static void with() {
    System.out.println("--------------------withxxxx-------------------");
    LocalDateTime datetime = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
    System.out.println(datetime);
    final LocalDateTime datetime1 = datetime.withDayOfMonth(31); // 获取datetime所在时间的当月31号
    System.out.println(datetime1);
    final LocalDateTime datetime2 = datetime1.withMonth(2); // 获取datetime1所在时间的当年8月
    System.out.println(datetime2);
  }

  private static void crontab() {
    System.out.println("------------------crontab---------------");
    // 本月第一天00:00:00
    final LocalDateTime firstDayOfMonth = LocalDate.now().withDayOfMonth(1).atStartOfDay();
    System.out.println(firstDayOfMonth);
    // 本月最后一天
    final LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    System.out.println(lastDay);
    // 下月第一天
    final LocalDate nextMonthFirstDay =
        LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
    System.out.println(nextMonthFirstDay);
    // 本月第一个周一
    final LocalDate firstWeekday =
        LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
    System.out.println(firstWeekday);
  }

  private static void compare() {
    System.out.println("--------------compare------------------");
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime target = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
    System.out.println(now.isBefore(target));
    System.out.println(LocalDate.now().isBefore(LocalDate.of(2019, 11, 19)));
    System.out.println(LocalTime.now().isAfter(LocalTime.parse("08:15:00")));
  }

  private static void duration() {
    System.out.println("---------------duration--------------------");
    LocalDateTime start = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
    LocalDateTime end = LocalDateTime.of(2020, 1, 9, 19, 25, 30);
    Duration d = Duration.between(start, end);
    System.out.println(d);

    Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2020, 1, 9));
    System.out.println(p);
  }
}
