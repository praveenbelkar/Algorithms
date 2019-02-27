package com.algorithm.leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Given a binary tree, find its minimum depth.

         3
        / \
       9  20
         /  \
        15   7
 */
public class P111_MinimumDepthBinaryTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return val + "";
        }
    }

    public int minDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return 1;
        }
        int leftHeight = Integer.MAX_VALUE;
        int rightHeight = Integer.MAX_VALUE;
        if(node.left != null) {
            leftHeight = minDepth(node.left);
        }
        if(node.right != null) {
            rightHeight = minDepth(node.right);
        }
        return 1 + Math.min(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        P111_MinimumDepthBinaryTree mainObject = new P111_MinimumDepthBinaryTree();
        TreeNode node1 = mainObject.new TreeNode(1);
        TreeNode node2 = mainObject.new TreeNode(2);
        TreeNode node3 = mainObject.new TreeNode(3);
        TreeNode node4 = mainObject.new TreeNode(4);
        TreeNode node5 = mainObject.new TreeNode(5);

        /*node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node4;
        node3.right = node5;*/
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        System.out.println(mainObject.minDepth(node1));
    }
}
