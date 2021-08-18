package com.study.designpattern.creative.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 原型模式
 *
 * <p>根据一个现有对象实例复制出一个新的实例，复制出的类型和属性与原实例相同。
 *
 * <p>使用场景
 * <li>(1)类初始化需要消化非常多的资源,这个资源包括数据、硬件资源等,通过原型拷贝避免这些消耗。
 * <li>(2)通过new一个对象需要非常繁琐的数据准备或访问权限,可以使用原型模式。
 * <li>(3)一个对象需要提供给其他对象访问,而且各个调用者可能需要修改其值,可以考虑使用原型模式拷贝多个对象供调用者使用,即保护性拷贝
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
