package com.exp.leetcode.recursion.easy;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。<br>
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * <p>请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * <p>你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 * @number 2
 * @date 2021/5/13 4:41 PM
 */
public class AddTwoNumbers {
  protected static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode cur1 = l1;
    ListNode cur2 = l2;
    ListNode result = new ListNode();
    final ListNode resultHead = result;
    while (cur1 != null || cur2 != null) {
      if (cur1 != null && cur2 != null) {
        int sum = cur1.val + cur2.val + result.val;
        if (sum > 9) {
          result.val = sum - 10;
          result.next = new ListNode(1);
        } else {
          result.val = sum;
          result.next = cur1.next != null || cur2.next != null ? new ListNode() : null;
        }
      } else if (cur1 != null && cur2 == null) {
        int sum = cur1.val + result.val;
        if (sum > 9) {
          result.val = sum - 10;
          result.next = new ListNode(1);
        } else {
          result.val = sum;
          result.next = cur1.next != null ? new ListNode() : null;
        }
      } else {
        int sum = cur2.val + result.val;
        if (sum > 9) {
          result.val = sum - 10;
          result.next = new ListNode(1);
        } else {
          result.val = sum;
          result.next = cur2.next != null ? new ListNode() : null;
        }
      }

      result = result.next;
      cur1 = cur1 == null ? null : cur1.next;
      cur2 = cur2 == null ? null : cur2.next;
    }

    return resultHead;
  }
}
