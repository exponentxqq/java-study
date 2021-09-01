package com.study.base.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileStreamRead {
  private static final Scanner scanner = new Scanner(System.in);
  private static final String FILENAME = "test.txt";

  public static void main(String[] args) {
    File file = new File("." + File.separator + FILENAME);
  }

  private static void classicWay(File file) {
    System.out.println("----------经典方式----------");
    try (
    // 建立从文件到程序的数据输入流(byte)
    FileInputStream inputStream = new FileInputStream(file);
        // stream reader将byte流转为char
        InputStreamReader streamReader =
            new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        // buffer reader将char转为string
        BufferedReader bufferedReader = new BufferedReader(streamReader)) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        System.out.println("读取文件：" + line);
      }
    } catch (IOException e) {
      System.out.println(e.toString());
    }
  }

  private static void coolerWay(File file) {
    System.out.println("----------高级方式----------");
    try (
    // 建立从文件到程序的数据输入流(byte)
    FileInputStream inputStream = new FileInputStream(file);
        // stream reader将byte流转为char
        InputStreamReader streamReader =
            new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        // buffer reader将char转为string
        BufferedReader bufferedReader = new BufferedReader(streamReader)) {
      bufferedReader
          .lines()
          .map(String::trim)
          .map(String::toUpperCase)
          .forEach(System.out::println);
    } catch (IOException e) {
      System.out.println(e.toString());
    }
  }
}
