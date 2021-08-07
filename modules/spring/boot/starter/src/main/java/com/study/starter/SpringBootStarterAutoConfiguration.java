package com.study.starter;

import javax.annotation.Resource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.study.starter")
@EnableConfigurationProperties(SpringBootStarterProperties.class)
public class SpringBootStarterAutoConfiguration {
  @Resource SpringBootStarterProperties properties;

  @Bean
  public Student student100() {
    return Student.create(properties.getStudentName());
  }
}
