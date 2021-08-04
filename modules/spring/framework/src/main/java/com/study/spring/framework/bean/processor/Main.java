package com.study.spring.framework.bean.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** @date 2021/8/4 21:22 */
@Slf4j
public class Main {
  public static void main(String[] args) {
    final ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("bean/processor/application-context.xml");
    final ProcessorBean bean = (ProcessorBean) context.getBean("processorBean");
    final ProcessorBean bean1 = (ProcessorBean) context.getBean("processorBean1");
    log.info(bean.toString());
    log.info(bean == bean1 ? "true" : "false"); // false
  }
}
