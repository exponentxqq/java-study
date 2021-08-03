package com.study.base.reflection;

import com.study.base.reflection.domain.Man;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyDemo {
  public static void main(String[] args) {
    invoke();
  }

  private static void invoke() {
    System.out.println("------------invoke interface instance------------");
    // 定义一个InvocationHandler实例，它负责实现接口的方法调用
    final InvocationHandler handler =
        (proxy, method, args) -> {
          System.out.println(method);
          if (method.getName().equals("talk")) {
            System.out.println("man talk by proxy");
          }
          return null;
        };
    // 通过Proxy.newProxyInstance()创建interface实例
    final Man man =
        (Man) Proxy.newProxyInstance(Man.class.getClassLoader(), new Class[] {Man.class}, handler);
    man.talk();

    final Man man1 =
        () -> {
          System.out.println("man talk by anonymous instance");
          return null;
        };
    man1.talk();
  }
}
