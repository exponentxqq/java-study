package com.study.base.reflection;

import com.study.base.reflection.domain.Person;
import com.study.base.reflection.domain.Student;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldDemo {
  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
    getField();
    getFieldValue();
    setFieldValue();
  }

  private static void getField() throws NoSuchFieldException {
    System.out.println("----------------get field info------------------");
    final Class<Student> studentClass = Student.class;
    // 获取public字段 score
    System.out.println(studentClass.getField("score"));
    // 获取继承的public字段 name
    System.out.println(studentClass.getField("name"));
    // 获取private的字段grade
    final Field gradeField = studentClass.getDeclaredField("grade");
    System.out.println(gradeField);
    final int modifiers = gradeField.getModifiers();
    System.out.println("is final: " + Modifier.isFinal(modifiers));
    System.out.println("is public: " + Modifier.isPublic(modifiers));
    System.out.println("is private: " + Modifier.isPrivate(modifiers));
    System.out.println("is static: " + Modifier.isStatic(modifiers));
    System.out.println("is synchronized: " + Modifier.isSynchronized(modifiers));
  }

  private static void getFieldValue() throws NoSuchFieldException, IllegalAccessException {
    System.out.println("----------------get field value--------------");
    final Person person = new Person("Xiao Ming");
    final Class<? extends Person> personClass = person.getClass();
    final Field nameField = personClass.getField("name");
    System.out.println("field name value: " + nameField.get(person));

    final Student student = new Student("Xiao Hong", 70, 3);
    final Class<? extends Student> studentClass = student.getClass();
    final Field gradeField = studentClass.getDeclaredField("grade");
    gradeField.setAccessible(true);
    System.out.println("field grade value: " + gradeField.get(student));
  }

  private static void setFieldValue() throws NoSuchFieldException, IllegalAccessException {
    System.out.println("--------------set field value-----------------");
    final Person person = new Person("Xiao Ming");
    final Class<? extends Person> personClass = person.getClass();
    final Field nameField = personClass.getField("name");
    nameField.set(person, "Xiao Ming Ming");
    System.out.println("person.name: " + person.name);

    final Student student = new Student("Xiao Hong", 60, 3);
    final Class<? extends Student> studentClass = student.getClass();
    final Field gradeField = studentClass.getDeclaredField("grade");
    gradeField.setAccessible(true);
    gradeField.set(student, 4);
    System.out.println("student.grade: " + gradeField.get(student));
  }
}
