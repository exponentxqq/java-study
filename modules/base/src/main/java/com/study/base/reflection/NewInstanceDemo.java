package com.study.base.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewInstanceDemo {
  public static void main(String[] args)
      throws NoSuchMethodException, InvocationTargetException, InstantiationException,
          IllegalAccessException {
    getConstructor();
  }

  private static void getConstructor()
      throws NoSuchMethodException, InvocationTargetException, InstantiationException,
          IllegalAccessException {
    // 根据参数类型获取构造函数
    final Constructor<Integer> constructor = Integer.class.getConstructor(int.class);
    final Integer integer = constructor.newInstance(1);
    System.out.println(integer);

    final Constructor<Integer> constructor1 = Integer.class.getConstructor(String.class);
    final Integer integer1 = constructor1.newInstance("123");
    System.out.println(integer1);
  }
}
