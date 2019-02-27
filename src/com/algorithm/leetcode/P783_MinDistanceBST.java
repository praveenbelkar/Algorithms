package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * Given a Binary Search Tree (BST) with the root node root,
 * return the minimum difference between the values of any two different nodes in the tree.
 *  Example :
 Input: root = [4,2,6,1,3,null,null]
 Output: 1
 */
public class P783_MinDistanceBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }
    Integer minDiff = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int minDiffInBST(TreeNode root) {
        inOrderTraverse(root);
        return minDiff;
    }

    private void inOrderTraverse(TreeNode current) {
        if(current != null) {
            inOrderTraverse(current.left);
            if(prev != null) {
                minDiff = Math.min(minDiff, current.val - prev.val);
            }
            prev = current;
            inOrderTraverse(current.right);
        }
    }

    public static void main(String[] args) {
        P783_MinDistanceBST mainObject = new P783_MinDistanceBST();
        TreeNode node27 = mainObject.new TreeNode(27);
        TreeNode node34 = mainObject.new TreeNode(34);
        TreeNode node58 = mainObject.new TreeNode(58);
        TreeNode node50 = mainObject.new TreeNode(50);
        TreeNode node44 = mainObject.new TreeNode(44);

        node27.right = node34;
        node34.right = node58;
        node58.left = node50;
        node50.left = node44;

        System.out.println(mainObject.minDiffInBST(node27));
    }
}
