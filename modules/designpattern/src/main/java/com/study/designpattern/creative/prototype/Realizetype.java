package com.study.designpattern.creative.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 原型模式
 *
 * <p>根据一个现有对象实例复制出一个新的实例，复制出的类型和属性与原实例相同。
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Realizetype implements Cloneable {
  private int attr1;
  private String attr2;

  // 除了构造函数外，还可以使用工厂模式来实现原型模式
  public Realizetype(Realizetype source) {
    this.attr1 = source.attr1;
    this.attr2 = source.attr2;
  }

  @Override
  public Realizetype clone() {
    final Realizetype realizetype = new Realizetype();
    realizetype.attr1 = this.attr1;
    realizetype.attr2 = this.attr2;
    return realizetype;
  }
}
