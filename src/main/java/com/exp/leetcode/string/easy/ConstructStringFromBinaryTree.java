package com.exp.leetcode.string.easy;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * <p>空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 *
 * @number 606
 * @date 2021/6/12 00:26
 */
public class ConstructStringFromBinaryTree {
  public String tree2str(TreeNode root) {
    if (root == null) return "";
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    Set<TreeNode> visited = new HashSet<>();
    StringBuilder s = new StringBuilder();

    while (!stack.isEmpty()) {
      root = stack.peek();
      if (visited.contains(root)) {
        stack.pop();
        s.append(")");
      } else {
        visited.add(root);
        s.append("(" + root.val);
        if (root.left == null && root.right != null) s.append("()");
        if (root.right != null) stack.push(root.right);
        if (root.left != null) stack.push(root.left);
      }
    }
    return s.substring(1, s.length() - 1);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
