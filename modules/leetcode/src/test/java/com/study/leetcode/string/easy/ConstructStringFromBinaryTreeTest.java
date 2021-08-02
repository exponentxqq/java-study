package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/6/12 00:27 */
public class ConstructStringFromBinaryTreeTest {
  @Test
  void test1() {
    ConstructStringFromBinaryTree constructStringFromBinaryTree =
        new ConstructStringFromBinaryTree();

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);

    String expected = "1(2(4))(3)";

    Assertions.assertEquals(expected, constructStringFromBinaryTree.tree2str(root));
  }

  @Test
  void test2() {
    ConstructStringFromBinaryTree constructStringFromBinaryTree =
        new ConstructStringFromBinaryTree();

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(4);

    String expected = "1(2()(4))(3)";

    Assertions.assertEquals(expected, constructStringFromBinaryTree.tree2str(root));
  }

  @Test
  void test3() {
    ConstructStringFromBinaryTree constructStringFromBinaryTree =
        new ConstructStringFromBinaryTree();

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);

    String expected = "1(2(3)(4))";

    Assertions.assertEquals(expected, constructStringFromBinaryTree.tree2str(root));
  }
}
