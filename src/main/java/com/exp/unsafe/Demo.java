package com.exp.unsafe;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

@Slf4j
public class Demo {
  public static void main(String[] args) {
    final Unsafe unsafe = getUnsafe();
    log.info(unsafe.toString());
  }

  private static sun.misc.Unsafe getUnsafe() {
    try {
      return sun.misc.Unsafe.getUnsafe();
    } catch (SecurityException tryReflectionInstead) {
    }
    try {
      return java.security.AccessController.doPrivileged(
          (PrivilegedExceptionAction<Unsafe>)
              () -> {
                Class<Unsafe> k = Unsafe.class;
                for (Field f : k.getDeclaredFields()) {
                  f.setAccessible(true);
                  Object x = f.get(null);
                  if (k.isInstance(x)) return k.cast(x);
                }
                throw new NoSuchFieldError("the Unsafe");
              });
    } catch (java.security.PrivilegedActionException e) {
      throw new RuntimeException("Could not initialize intrinsics", e.getCause());
    }
  }
}
