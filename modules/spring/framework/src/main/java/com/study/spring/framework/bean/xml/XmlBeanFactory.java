package com.study.spring.framework.bean.xml;

import java.util.List;
import lombok.Setter;

public class XmlBeanFactory {
  @Setter private int id;
  @Setter private List<XmlBeanProperty> properties;

  public String getString() {
    return "XmlBeanFactory: {id=>" + id + "; properties=>" + properties.toString() + "}";
  }
}

@Setter
class XmlBeanProperty {
  private int a;
  private String b;
}
