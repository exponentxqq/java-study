package com.study.base.reflection;

import com.study.base.reflection.domain.Student;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class MethodDemo {
  public static void main(String[] args)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    getMethod();
    callMethod();
    callStaticMethod();
  }

  private static void getMethod() throws NoSuchMethodException {
    System.out.println("-----------------get method info-------------------");
    final Class<Student> studentClass = Student.class;
    System.out.println(studentClass.getMethod("run", int.class));
    System.out.println(studentClass.getMethod("getScore"));

    final Method getGradeMethod = studentClass.getDeclaredMethod("getGrade");
    final int modifiers = getGradeMethod.getModifiers();
    System.out.println(getGradeMethod);
    System.out.println("method name: " + getGradeMethod.getName());
    System.out.println("return type: " + getGradeMethod.getReturnType());
    System.out.println("param types:" + Arrays.toString(getGradeMethod.getParameterTypes()));
    System.out.println("default value: " + getGradeMethod.getDefaultValue());
    System.out.println("is public: " + Modifier.isPublic(modifiers));
    System.out.println("is private: " + Modifier.isPrivate(modifiers));
  }

  private static void callMethod()
      throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
    System.out.println("----------------call method----------------------");
    final String str = "Hello World!";
    final Method substringMethod = String.class.getMethod("substring", int.class);
    final Object result = substringMethod.invoke(str, 4);
    System.out.println("substring result: " + result);

    final Student student = new Student("Xiao Hong", 60, 3);
    final Class<? extends Student> studentClass = student.getClass();
    final Method getGradeMethod = studentClass.getDeclaredMethod("getGrade");
    getGradeMethod.setAccessible(true);
    final Object result1 = getGradeMethod.invoke(student);
    System.out.println("student.getGrade result: " + result1);
  }

  private static void callStaticMethod()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    System.out.println("---------------call static method------------------");
    final Method parseIntMethod = Integer.class.getMethod("parseInt", String.class);
    final Object result = parseIntMethod.invoke(null, "12345");
    System.out.println("Integer.parseInt result: " + result);
  }
}
