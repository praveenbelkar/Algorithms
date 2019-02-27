package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * Given a binary tree, determine if it is height-balanced.
 For this problem, a height-balanced binary tree is defined as:
 a binary tree in which the depth of the two subtrees of every node
 never differ by more than 1.
 */
public class P110_BalancedBinaryTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return checkBalanced(root);
    }

    private boolean checkBalanced(TreeNode node) {
        TreeNode left = node.left;
        TreeNode right = node.right;
        if(left == null && right == null) {
            return true;
        }
        if(left == null && isLeaf(right)) {
            return true;
        }
        if(right == null && isLeaf(left)) {
            return true;
        }
        if(isLeaf(left) && isLeaf(right)) {
            return true;
        }
        return checkBalanced(left) && checkBalanced(right);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        P110_BalancedBinaryTree mainObject = new P110_BalancedBinaryTree();
        TreeNode node1 = mainObject.new TreeNode(1);
        TreeNode node2 = mainObject.new TreeNode(2);
        TreeNode node3 = mainObject.new TreeNode(3);
        TreeNode node4 = mainObject.new TreeNode(4);
        TreeNode node5 = mainObject.new TreeNode(5);
        TreeNode node6 = mainObject.new TreeNode(6);
        TreeNode node7 = mainObject.new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;

        System.out.println(mainObject.isBalanced(node1));
    }
}
