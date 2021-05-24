package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/5/24 11:26 PM */
public class DistanceBetweenBusStopsTest {
  @Test
  void test1() {
    DistanceBetweenBusStops distanceBetweenBusStops = new DistanceBetweenBusStops();

    int[] distance = {1, 2, 3, 4};
    int start = 0;
    int destination = 1;

    int expected = 1;

    Assertions.assertEquals(
        expected, distanceBetweenBusStops.distanceBetweenBusStops(distance, start, destination));
  }

  @Test
  void test2() {
    DistanceBetweenBusStops distanceBetweenBusStops = new DistanceBetweenBusStops();

    int[] distance = {1, 2, 3, 4};
    int start = 1;
    int destination = 3;

    int expected = 5;

    Assertions.assertEquals(
        expected, distanceBetweenBusStops.distanceBetweenBusStops(distance, start, destination));
  }

  @Test
  void test3() {
    DistanceBetweenBusStops distanceBetweenBusStops = new DistanceBetweenBusStops();

    int[] distance = {1, 2, 3, 4};
    int start = 1;
    int destination = 2;

    int expected = 2;

    Assertions.assertEquals(
        expected, distanceBetweenBusStops.distanceBetweenBusStops(distance, start, destination));
  }

  @Test
  void test4() {
    DistanceBetweenBusStops distanceBetweenBusStops = new DistanceBetweenBusStops();

    int[] distance = {7, 10, 1, 12, 11, 14, 5, 0};
    int start = 7;
    int destination = 2;

    int expected = 17;

    Assertions.assertEquals(
        expected, distanceBetweenBusStops.distanceBetweenBusStops(distance, start, destination));
  }
}
