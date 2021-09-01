package com.study.thread.base.consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) {
    Queue<String> urls = new LinkedList<>();

    Consumer<String> consumer = new Consumer<>(urls);
    Producer<String> producer = new Producer<>(urls, 1024);

    for (int i = 0; i < 100; i++) {
      Thread consumerThread =
          new Thread(
              () -> {
                while (true) {
                  try {
                    String url = consumer.consume();
                    processUrl(url);
                  } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                  }
                }
              },
              "consumer" + i);
      consumerThread.start();
    }

    for (int i = 0; i < 3; i++) {
      Thread producerThread =
          new Thread(
              () -> {
                while (true) {
                  try {
                    String url = produceUrl();
                    producer.produce(url);
                  } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                  }
                }
              },
              "producer" + i);
      producerThread.start();
    }
  }

  private static String produceUrl() {
    StringBuilder ret = new StringBuilder();
    ret.append("www.");
    for (int i = 0; i < 6; i++) {
      int rand = ((int) (Math.random() * 1000)) % 26;
      char ch = (char) (rand + 'a');
      ret.append(ch);
    }
    ret.append(".com");
    return ret.toString();
  }

  private static void processUrl(String url) throws InterruptedException {
    System.out.println("开始处理：" + url);
    Thread.sleep(TimeUnit.SECONDS.toMillis(1));
    System.out.println("处理完成：" + url);
  }
}
