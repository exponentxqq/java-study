package com.exp.designpattern.creative.singleton;

public class HungrySingleton {
  private static HungrySingleton instance = new HungrySingleton();

  private int count;

  // 饿汉式单例在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变
  // 所以是线程安全的，可以直接用于多线程而不会出现问题。
  public static HungrySingleton getInstance() {
    return instance;
  }

  public void incr() {
    count++;
  }
}
