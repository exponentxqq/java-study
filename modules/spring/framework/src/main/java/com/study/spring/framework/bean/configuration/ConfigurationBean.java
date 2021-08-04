package com.study.spring.framework.bean.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * BeanNameAware接口实现后，会自动注入beanName
 *
 * <p>ApplicationContextAware接口实现后，会自动注入提供当前Bean的ApplicationContext
 */
@Setter
@Getter
public class ConfigurationBean implements BeanNameAware, ApplicationContextAware {
  private String beanName;
  private ApplicationContext applicationContext;
}
