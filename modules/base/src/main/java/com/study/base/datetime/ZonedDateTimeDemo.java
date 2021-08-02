package com.study.base.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * LocalDateTime总是表示本地日期和时间，要表示一个带时区的日期和时间，我们就需要ZonedDateTime
 *
 * <p>可以简单地把ZonedDateTime理解成LocalDateTime加ZoneId
 */
public class ZonedDateTimeDemo {
  public static void main(String[] args) {
    baseUsage();
    transferZT();
  }

  private static void baseUsage() {
    System.out.println("-----------------base usage-------------");
    final ZonedDateTime nowLocal = ZonedDateTime.now();
    final ZonedDateTime nowOfNewYork = ZonedDateTime.now(ZoneId.of("America/New_York"));
    // 时间不同，时区也不同，是同一时刻
    System.out.println(nowLocal);
    System.out.println(nowOfNewYork);

    LocalDateTime datetime = LocalDateTime.of(2019, 9, 15, 15, 16, 17);
    final ZonedDateTime datetimeOfLocal = datetime.atZone(ZoneId.systemDefault());
    final ZonedDateTime datetimeOfNewYork = datetime.atZone(ZoneId.of("America/New_York"));
    // 时间相同，时区不同，不是同一时刻
    System.out.println(datetimeOfLocal);
    System.out.println(datetimeOfNewYork);
  }

  private static void transferZT() {
    System.out.println("---------------transfer zone time--------------");
    final ZonedDateTime nowOfLocal = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
    final ZonedDateTime nowOfNewYork =
        nowOfLocal.withZoneSameInstant(ZoneId.of("America/New_York"));
    System.out.println(nowOfLocal);
    System.out.println(nowOfNewYork);
  }
}
