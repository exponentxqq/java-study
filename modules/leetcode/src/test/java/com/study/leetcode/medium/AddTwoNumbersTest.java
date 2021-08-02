package com.study.leetcode.medium;

import com.study.leetcode.medium.AddTwoNumbers.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddTwoNumbersTest {
  @Test
  void test1() {
    final AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    final ListNode l1 = mockList(new int[] {2, 4, 3});
    final ListNode l2 = mockList(new int[] {5, 6, 4});

    ListNode expected = mockList(new int[] {7, 0, 8});

    assertList(expected, addTwoNumbers.addTwoNumbers(l1, l2));
  }

  @Test
  void test2() {
    final AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    final ListNode l1 = mockList(new int[] {2, 4});
    final ListNode l2 = mockList(new int[] {5, 6, 4});

    ListNode expected = mockList(new int[] {7, 0, 5});

    assertList(expected, addTwoNumbers.addTwoNumbers(l1, l2));
  }

  private ListNode mockList(int[] nums) {
    final ListNode head = new ListNode(nums[0]);
    ListNode pre = head;
    for (int i = 1; i < nums.length; i++) {
      pre.next = new ListNode(nums[i]);
      pre = pre.next;
    }
    return head;
  }

  private void assertList(ListNode expected, ListNode actual) {
    ListNode p1 = expected;
    ListNode p2 = actual;
    do {
      Assertions.assertEquals(p1.val, p2.val);
      p1 = p1.next;
      p2 = p2.next;
    } while (p1.next != null && p2.next != null);
  }
}
