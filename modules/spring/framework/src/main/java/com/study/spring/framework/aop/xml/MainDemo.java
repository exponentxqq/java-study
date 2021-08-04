package com.study.spring.framework.aop.xml;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDemo {
  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("aop/xml/application-context.xml");
    final AopXmlBean bean = context.getBean(AopXmlBean.class);
    final AopXmlBean bean1 = new AopXmlBean(1, "a");
    bean.print();
    // 非spring Bean无法使用aop
    bean1.print();
  }
}

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
class AopXmlBean {
  private int a;
  private String b;

  public void print() {
    log.info("AopXmlBean: a: {}, b: {}", a, b);
  }
}
