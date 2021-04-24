package com.exp.util;

import java.util.ArrayList;
import java.util.Random;

public class Mocker {
  public static int[] mockUniqueIntArray(int min, int max, int size) {
    if (size > max - min) {
      throw new RuntimeException("能生成的数字少于size");
    }
    ArrayList<Integer> numbers = new ArrayList<>(size);
    while (numbers.size() < size) {
      Random random = new Random();
      int temp = random.nextInt(max - min) + min;
      if (!numbers.contains(temp)) {
        numbers.add(temp);
      }
    }
    return numbers.stream().mapToInt(item -> item).toArray();
  }
}
