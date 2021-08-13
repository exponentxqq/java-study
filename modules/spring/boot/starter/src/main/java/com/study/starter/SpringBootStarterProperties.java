package com.study.starter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = SpringBootStarterProperties.PREFIX)
@Setter
@Getter
public class SpringBootStarterProperties {
  public static final String PREFIX = "starter";
  private String studentName = "autoconfig";
}
