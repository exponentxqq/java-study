package com.study.book.nettyauthoritative.nio;

import java.io.IOException;

public class TimeClient {
  public static void main(String[] args) throws IOException {
    new Thread(new TimeClientHandler(), "NIO-TimeClient-001").start();
  }
}
