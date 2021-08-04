package com.study.spring.framework.bean.xml;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** @date 2021/8/4 20:38 */
@Slf4j
public class Main {
  public static void main(String[] args) {
    final ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("bean/xml/application-context.xml");
    final Object factory1 = context.getBean("xmlBeanFactory");
    final XmlBeanFactory factory2 = context.getBean(XmlBeanFactory.class);
    log.info(factory1 == factory2 ? "true" : "false"); // true
    log.info(factory1.toString());
    log.info(factory2.toString());
    log.info(factory2.getString());
  }
}
