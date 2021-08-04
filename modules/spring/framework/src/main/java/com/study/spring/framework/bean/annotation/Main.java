package com.study.spring.framework.bean.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** @date 2021/8/4 20:46 */
@Slf4j
public class Main {
  public static void main(String[] args) {
    final ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("bean/annotation/application-context.xml");
    final AnnotationBeanFactory bean = context.getBean(AnnotationBeanFactory.class);
    log.info(bean.toString());
    bean.print();
  }
}
