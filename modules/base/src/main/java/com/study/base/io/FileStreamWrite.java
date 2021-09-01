package com.study.base.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileStreamWrite {
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {}

  private static File createFile() throws IOException {
    System.out.println("输入文件名");
    String filename = scanner.nextLine();
    File file = new File("." + File.separator + filename + ".txt");
    if (!file.isFile()) {
      boolean created = file.createNewFile();
      System.out.println("创建文件" + file.getAbsoluteFile() + ": " + created);
    }
    if (!file.isFile()) {
      throw new RuntimeException("文件不存在");
    }
    return file;
  }

  private static void write(File file) {
    try (
    // 创建一个input stream，建立一个从文件到程序的byte数据流
    FileOutputStream outputStream = new FileOutputStream(file);
        // 建立一个可以消费input stream的writer，并指定字符集
        OutputStreamWriter streamWriter =
            new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        // 使用printWriter，可以方便的写入一行字符
        PrintWriter printWriter = new PrintWriter(streamWriter)) {
      System.out.println("输入的内容会实时写入文件，输入空行程序结束");
      while (true) {
        String line = scanner.nextLine().trim();
        if (line.isBlank()) {
          System.out.println("程序结束");
          break;
        } else {
          System.out.println("输入的内容为：" + line);
          printWriter.println(line);
          printWriter.flush();
        }
      }

    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }
}
