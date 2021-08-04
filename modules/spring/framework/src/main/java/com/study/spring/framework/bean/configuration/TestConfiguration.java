package com.study.spring.framework.bean.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** @date 2021/8/4 22:47 */
@Configuration
public class TestConfiguration {
  @Bean
  public ConfigurationBean configurationBean() {
    return new ConfigurationBean();
  }
}
