package com.study.base.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class InstantDemo {
  public static void main(String[] args) {
    timestamp();
    toZonedDateTime();
    toLocalDateTime();
    format();
  }

  private static void timestamp() {
    System.out.println("------------timestamp---------------");
    final Instant now = Instant.now();
    System.out.println(now.getEpochSecond());
    System.out.println(now.toEpochMilli());
  }

  private static void toZonedDateTime() {
    System.out.println("------------to ZonedDateTime---------------");
    final Instant instant = Instant.ofEpochSecond(1568568760);
    final ZonedDateTime datetime = instant.atZone(ZoneId.systemDefault());
    System.out.println(datetime);
    final Instant reverted = datetime.toInstant();
    System.out.println(reverted);
  }

  private static void toLocalDateTime() {
    System.out.println("------------to LocalDateTime---------------");
    final Instant instant = Instant.ofEpochSecond(1568568760);
    final ZonedDateTime datetime = instant.atZone(ZoneId.systemDefault());
    final LocalDateTime localDateTime = datetime.toLocalDateTime();
    System.out.println(datetime);
    System.out.println(localDateTime);
    final Instant reverted = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    System.out.println(reverted);
  }

  private static void format() {
    System.out.println("-------------format-------------------");
    final Instant now = Instant.now();
    DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").withZone(ZoneId.systemDefault());
    System.out.println("format: " + formatter.format(now));
  }
}
