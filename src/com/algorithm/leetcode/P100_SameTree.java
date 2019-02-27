package com.algorithm.leetcode;


/**
 * https://leetcode.com/problems/same-tree/
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and
 * the nodes have the same value.
 */
public class P100_SameTree {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean isFirstNodeNull = p == null;
        boolean isSecondNodeNull = q == null;
        if(p == null && q == null) {
            return true;
        }

        if(isFirstNodeNull ^ isSecondNodeNull) {
            return false;
        }

        return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right,q.right));
    }

    public static void main(String[] args) {
        P100_SameTree mainObject = new P100_SameTree();
        TreeNode node1 = mainObject.new TreeNode(1);
        TreeNode node2 = mainObject.new TreeNode(2);
        TreeNode node3 = mainObject.new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = mainObject.new TreeNode(1);
        TreeNode node5 = mainObject.new TreeNode(2);
        TreeNode node6 = mainObject.new TreeNode(3);
        node4.left = node5;
        node4.right = node6;

        System.out.println(mainObject.isSameTree(node1, node4));
    }
}
