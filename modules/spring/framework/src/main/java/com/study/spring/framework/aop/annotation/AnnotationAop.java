package com.study.spring.framework.aop.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
public class AnnotationAop {
  @Pointcut(
      value = "execution(* com.study.spring.framework.aop.annotation.AnnotationAopBean.*(..))")
  public void point() {
    // aop point cut
  }

  @Before(value = "point()")
  public void before() {
    log.info("========> begin... //2");
  }

  @AfterReturning(value = "point()")
  public void after() {
    log.info("========> after... //4");
  }

  @Around("point()")
  public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    log.info("========> around begin //1");
    joinPoint.proceed();
    log.info("========> around after //3");
    return null;
  }
}
