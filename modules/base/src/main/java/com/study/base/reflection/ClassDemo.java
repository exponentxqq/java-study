package com.study.base.reflection;

import java.lang.reflect.InvocationTargetException;
import java.time.Month;

public class ClassDemo {
  public static void main(String[] args)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException,
          NoSuchMethodException, InvocationTargetException {
    nature();
    printClassInfo();
    newInstance();
  }

  private static void nature() throws ClassNotFoundException {
    final Class<String> stringClass = String.class;
    final Class<? extends String> stringClass1 = "Hello".getClass();
    final Class<?> stringClass2 = Class.forName("java.lang.String");
    if (stringClass == stringClass1 && stringClass == stringClass2) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }

    final Integer a = 123;
    System.out.println("a[" + a + "] instanceof Integer: " + (a instanceof Integer));
    System.out.println("a[" + a + "] instanceof Number: " + (a instanceof Number));
    System.out.println("a.class == Integer.class: " + (a.getClass() == Integer.class));
    // System.out.println("a.class == Number.class: " + (a.getClass() == Number.class)); // false
  }

  private static void printClassInfo() {
    print("".getClass());
    print(Runnable.class);
    print(Month.class);
    print(String[].class);
    print(int.class);
    print(Integer.class);
  }

  private static void newInstance()
      throws InstantiationException, IllegalAccessException, NoSuchMethodException,
          InvocationTargetException {
    // 只能调用public的无参数构造方法
    final String str = String.class.newInstance();
    final Object str1 = String.class.getConstructor(String.class).newInstance("abcd");
    System.out.println(str1);
  }

  private static void print(Class clazz) {
    System.out.println("Class name: " + clazz.getName());
    System.out.println("Simple name: " + clazz.getSimpleName());
    if (clazz.getPackage() != null) {
      System.out.println("Package name: " + clazz.getPackage().getName());
    }
    System.out.println("is interface: " + clazz.isInterface());
    System.out.println("is enum: " + clazz.isEnum());
    System.out.println("is array: " + clazz.isArray());
    // 是否是基本类型
    System.out.println("is primitive: " + clazz.isPrimitive());
  }
}
