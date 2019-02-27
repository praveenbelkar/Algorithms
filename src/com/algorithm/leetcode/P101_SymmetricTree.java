package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/symmetric-tree/
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

         1
        / \
       2   2
      / \ / \
     3  4 4  3
 */
public class P101_SymmetricTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        return left.val == right.val &&
                isMirror(left.left, right.right) &&
                isMirror(left.right, right.left);
    }


    public static void main(String[] args) {
        P101_SymmetricTree mainObject = new P101_SymmetricTree();
        TreeNode node1 = mainObject.new TreeNode(1);
        TreeNode node2 = mainObject.new TreeNode(2);
        TreeNode node3 = mainObject.new TreeNode(2);
        TreeNode node4 = mainObject.new TreeNode(3);
        TreeNode node5 = mainObject.new TreeNode(4);
        TreeNode node6 = mainObject.new TreeNode(4);
        TreeNode node7 = mainObject.new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;

        System.out.println(mainObject.isSymmetric(node1));
    }

}
