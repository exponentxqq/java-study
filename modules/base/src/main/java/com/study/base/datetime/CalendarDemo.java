package com.study.base.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalendarDemo {
  private static final List<String> WEEK_DAYS =
      List.of("", "星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");

  public static void main(String[] args) {
    final Calendar calendar = Calendar.getInstance();
    final int year = calendar.get(Calendar.YEAR);
    final int month = calendar.get(Calendar.MONTH) + 1;
    final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    final int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    final int hour = calendar.get(Calendar.HOUR_OF_DAY);
    final int minute = calendar.get(Calendar.MINUTE);
    final int second = calendar.get(Calendar.SECOND);
    final int millisecond = calendar.get(Calendar.MILLISECOND);

    log.info(
        "{}年{}月{}日 {} {}:{}:{}:{}",
        year,
        month,
        dayOfMonth,
        WEEK_DAYS.get(dayOfWeek),
        hour,
        minute,
        second,
        millisecond);
    log.info("format: " + format(calendar));
  }

  private static String format(Calendar calendar) {
    final Date date = calendar.getTime();
    final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return formatter.format(date);
  }

  private static void transferTZ(Calendar calendar) {}
}
