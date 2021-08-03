package com.study.designpattern.creative.prototype;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RealizetypeTest {
  @Test
  void constructTest() {
    final Realizetype a = new Realizetype(1, "a");
    final Realizetype b = new Realizetype(a);

    Assertions.assertNotEquals(a, b);
    Assertions.assertEquals(a.getAttr1(), b.getAttr1());
    Assertions.assertEquals(a.getAttr2(), b.getAttr2());
  }

  @Test
  void cloneTest() {
    final Realizetype a = new Realizetype(1, "a");
    final Realizetype b = a.clone();

    Assertions.assertNotEquals(a, b);
    Assertions.assertEquals(a.getAttr1(), b.getAttr1());
    Assertions.assertEquals(a.getAttr2(), b.getAttr2());
  }
}
