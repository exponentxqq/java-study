package com.study.base.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
  public static void main(String[] args) {
    // date类已经几乎被弃用了
    final Date date = new Date();
    System.out.println(date.getYear() + 1900); // 必须加1900
    System.out.println(date.getMonth() + 1); // 0~11，必须加1
    System.out.println(date.getDate()); // 1~31，不能加1
    System.out.println(date.toString());
    System.out.println(date.toGMTString());
    System.out.println(date.toLocaleString());

    System.out.println("format: " + format(date));
  }

  private static String format(Date date) {
    final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return formatter.format(date);
  }
}
