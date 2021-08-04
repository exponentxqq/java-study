package com.study.spring.framework.aop.annotation;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDemo {
  public static void main(String[] args) {
    final ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("aop/annotation/application-context.xml");
    final AnnotationAopBean bean = context.getBean(AnnotationAopBean.class);
    bean.print();
  }
}

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
class AnnotationAopBean {
  private int a;
  private String b;

  public void print() {
    log.info("AnnotationAopBean: a: {}, b: {}", a, b);
  }
}
