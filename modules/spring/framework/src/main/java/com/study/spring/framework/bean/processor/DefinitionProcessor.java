package com.study.spring.framework.bean.processor;

import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 在扫描xml，构建好dom之后，会走到这个类
 *
 * <p>可以获得当前扫描到的所有bean，此时这些bean还未初始化，即所有的bean的成员属性现在都是null(设了默认值的除外)
 */
@Component
@Slf4j
public class DefinitionProcessor implements BeanDefinitionRegistryPostProcessor {

  @Override
  public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry)
      throws BeansException {
    log.info("扫描到的Bean个数：" + beanDefinitionRegistry.getBeanDefinitionCount());
    log.info("扫描到的Bean名称：" + Arrays.toString(beanDefinitionRegistry.getBeanDefinitionNames()));
    RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(ProcessorBean.class);
    final ArrayList<String> tags = new ArrayList<>();
    tags.add("DefinitionProcessor");
    rootBeanDefinition.getPropertyValues().add("id", 1).add("tags", tags);
    // 这里可以增加新的Bean，也可以更新已有的Bean，还可以删除某个Bean
    beanDefinitionRegistry.registerBeanDefinition("processorBean", rootBeanDefinition);
    log.info("postProcessBeanDefinitionRegistry");
  }

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
    // 这里所有的Bean都已经进入Factory，只能新增，不能删除
    log.info(" ==> 扫描到的Bean个数: " + beanFactory.getBeanDefinitionCount());
    log.info(" ==> 扫描到的单例数量: " + beanFactory.getSingletonCount());
    log.info(" ==> 扫描到的Bean名称: " + String.join(",", beanFactory.getBeanDefinitionNames()));
    final BeanDefinition beanDefinition = beanFactory.getBeanDefinition("processorBean");
    beanDefinition
        .getPropertyValues()
        .add("id", (int) beanDefinition.getPropertyValues().getPropertyValue("id").getValue() + 1);
    final ProcessorBean processorBean = new ProcessorBean();
    beanFactory.registerSingleton("processorBean1", processorBean);
    log.info(" ==> 扫描到的Bean个数: " + beanFactory.getBeanDefinitionCount());
    log.info(" ==> 扫描到的单例数量: " + beanFactory.getSingletonCount());
  }
}
