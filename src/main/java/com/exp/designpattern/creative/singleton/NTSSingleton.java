package com.exp.designpattern.creative.singleton;

import lombok.Getter;

/** 非线程安全 单例 */
public class NTSSingleton {
  public static NTSSingleton instance = null;

  @Getter private int count = 1;

  public static NTSSingleton getInstance() {
    if (instance == null) {
      instance = new NTSSingleton();
    }
    return instance;
  }

  public void incr() {
    count++;
  }
}
