package com.study.thread.base.consumer;

import java.util.Queue;

public class Consumer<T> {
  private final Queue<T> tasks;

  public Consumer(Queue<T> tasks) {
    this.tasks = tasks;
  }

  public T consume() throws InterruptedException {
    synchronized (tasks) {
      while (tasks.size() == 0) {
        System.out.println("消费者线程进入等待" + Thread.currentThread().getName());
        tasks.wait();
      }
      T ret = tasks.poll();
      tasks.notifyAll();
      return ret;
    }
  }
}
