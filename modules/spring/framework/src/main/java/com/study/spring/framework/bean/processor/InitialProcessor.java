package com.study.spring.framework.bean.processor;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/** Bean的初始化前后会走到这个类 */
@Slf4j
@Component
public class InitialProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
    log.info("before: " + o.toString() + "; " + s);
    if (o instanceof ProcessorBean) {
      ProcessorBean bean = (ProcessorBean) o;
      bean.setId(bean.getId() + 100);
      final List<String> tags =
          CollectionUtils.isEmpty(bean.getTags()) ? new ArrayList<>() : bean.getTags();

      tags.add("InitialProcessor-before-add");
      bean.setTags(tags);
    }
    return o;
  }

  @Override
  public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
    log.info("after: " + o.toString() + ";" + s);
    if (o instanceof ProcessorBean) {
      ProcessorBean bean = (ProcessorBean) o;
      bean.setId(bean.getId() + 100);
      final List<String> tags =
          CollectionUtils.isEmpty(bean.getTags()) ? new ArrayList<>() : bean.getTags();

      tags.add("InitialProcessor-after-add");
      bean.setTags(tags);
    }
    return o;
  }
}
