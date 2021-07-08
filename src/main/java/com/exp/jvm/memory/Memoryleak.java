package com.exp.jvm.memory;

import java.util.HashMap;
import java.util.Map;

/** @date 2021/7/7 22:37 */
public class Memoryleak {
  static class Key {
    Integer id;

    Key(Integer id) {
      this.id = id;
    }

    @Override
    public int hashCode() {
      return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o instanceof Key) {
        return (((Key) o).id).equals(this.id);
      }
      return false;
    }
  }

  public static void main(String[] args) {
    Map<Key, String> m = new HashMap<>();
    while (true) {
      for (int i = 0; i < 10000; i++) {
        if (!m.containsKey(new Key(i))) {
          m.put(new Key(i), "Number: " + i);
        }
      }
      System.out.println("m.size() = " + m.size());
    }
  }
}
