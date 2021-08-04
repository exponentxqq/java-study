package com.study.spring.framework.aop.xml;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;

@Slf4j
public class XmlAop {
  // 前置
  public void startTransaction() {
    log.info("    ====> begin... "); // 2
  }

  // 后置
  public void commitTransaction() {
    log.info("    ====> finish... "); // 4
  }

  // 环绕
  public void around(ProceedingJoinPoint joinPoint) throws Throwable {
    log.info("    ====> around begin..."); // 1
    // 调用process()方法才会真正的执行实际被代理的方法
    joinPoint.proceed();
    log.info("    ====> around finish"); // 3
  }
}
