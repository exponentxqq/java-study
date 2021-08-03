package com.study.spring.framework.aop.xml;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** @date 2021/8/4 00:23 */
public class MainDemo {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("aop/application-context.xml");
    final AopXmlDomain domain = new AopXmlDomain(1, "aaa");
    domain.print();
  }
}

@Slf4j
@AllArgsConstructor
class AopXmlDomain {
  private int a;
  private String b;

  public void print() {
    log.info("AopXmlDomain: a: {}, b: {}", a, b);
  }
}
