package com.exp.jvm.classloader;

import java.lang.reflect.InvocationTargetException;
import java.util.Base64;

/** @date 2021/6/23 23:48 */
public class HelloClassLoader extends ClassLoader {
  public static void main(String[] args)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException,
          NoSuchMethodException, InvocationTargetException {
    new HelloClassLoader()
        .findClass("com.exp.jvm.classloader.Hello")
        .getDeclaredConstructor()
        .newInstance();
  }

  @Override
  protected Class<?> findClass(String name) {
    String helloClassBase64 =
        "yv66vgAAADkAHAoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCQAIAAkHAAoMAAsADAEAEGphdmEvbGFuZy9TeXN0ZW0BAANvdXQBABVMamF2YS9pby9QcmludFN0cmVhbTsIAA4BABhIZWxsbyBDbGFzcyBJbml0aWFsaXplZCEKABAAEQcAEgwAEwAUAQATamF2YS9pby9QcmludFN0cmVhbQEAB3ByaW50bG4BABUoTGphdmEvbGFuZy9TdHJpbmc7KVYHABYBAB1jb20vZXhwL2p2bS9jbGFzc2xvYWRlci9IZWxsbwEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAg8Y2xpbml0PgEAClNvdXJjZUZpbGUBAApIZWxsby5qYXZhACEAFQACAAAAAAACAAEABQAGAAEAFwAAAB0AAQABAAAABSq3AAGxAAAAAQAYAAAABgABAAAABAAIABkABgABABcAAAAlAAIAAAAAAAmyAAcSDbYAD7EAAAABABgAAAAKAAIAAAAGAAgABwABABoAAAACABs=";
    final byte[] bytes = Base64.getDecoder().decode(helloClassBase64);
    return defineClass(name, bytes, 0, bytes.length);
  }
}
