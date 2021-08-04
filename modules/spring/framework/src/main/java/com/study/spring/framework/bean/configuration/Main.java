package com.study.spring.framework.bean.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** @date 2021/8/4 22:47 */
@Slf4j
public class Main {
  public static void main(String[] args) {
    final AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(TestConfiguration.class);
    final ConfigurationBean bean1 = (ConfigurationBean) context.getBean("configurationBean");
    final ConfigurationBean bean2 = context.getBean(ConfigurationBean.class);
    log.info(bean1 == bean2 ? "true" : "false"); // true
    log.info(bean1.getBeanName());
    log.info(bean1.getApplicationContext().toString());
  }
}
