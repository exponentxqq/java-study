package com.study.thread.base.consumer;

import java.util.Queue;

public class Producer<T> {
  private final Queue<T> tasks;

  private int maxTaskCount = 0;

  public Producer(Queue<T> tasks, int maxTaskCount) {
    this.tasks = tasks;
    this.maxTaskCount = maxTaskCount;
  }

  public void produce(T task) throws InterruptedException {
    synchronized (tasks) {
      while (tasks.size() >= maxTaskCount) {
        // 如果队列中任务数已经达到最大，暂时先不再增加任务，等待消费者消费掉再增加
        System.out.println("生产者线程进入等待：" + Thread.currentThread().getName());
        tasks.wait();
      }
      tasks.add(task);
      tasks.notifyAll();
    }
  }
}
