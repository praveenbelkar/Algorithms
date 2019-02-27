package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Given a binary tree, find its maximum depth.
 */
public class P104_MaxDepthBinaryTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        P104_MaxDepthBinaryTree mainObject = new P104_MaxDepthBinaryTree();
        TreeNode node1 = mainObject.new TreeNode(1);
        TreeNode node2 = mainObject.new TreeNode(2);
        TreeNode node3 = mainObject.new TreeNode(3);
        TreeNode node4 = mainObject.new TreeNode(4);
        TreeNode node5 = mainObject.new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        /*node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;*/
        System.out.println(mainObject.maxDepth(node1));
    }
}
