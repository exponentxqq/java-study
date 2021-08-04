package com.study.spring.framework.bean.processor;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/** @date 2021/8/4 21:22 */
@Component
@Setter
@Getter
public class ProcessorBean {
  private int id;
  private List<String> tags;
}
