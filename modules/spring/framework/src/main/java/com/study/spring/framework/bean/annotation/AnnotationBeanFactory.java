package com.study.spring.framework.bean.annotation;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** @date 2021/8/4 20:46 */
@Component
@Setter
@Slf4j
public class AnnotationBeanFactory {
  @Autowired private List<AnnotationBeanProperty> properties;

  public void print() {
    log.info(
        String.format(
            "AnnotationBeanFactory: {properties=>%s}",
            properties.stream()
                .map(AnnotationBeanProperty::toString)
                .collect(Collectors.joining(","))));
  }
}

@Setter
class AnnotationBeanProperty {
  private int a;
  private String b;

  public String toString() {
    return "AnnotationBeanProperty: {a=>" + a + "; b=>" + b + "}";
  }
}
