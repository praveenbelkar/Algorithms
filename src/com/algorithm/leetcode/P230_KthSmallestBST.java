package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 */
public class P230_KthSmallestBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int count = 0;
    Integer result = null;
    public int kthSmallest(TreeNode root, int k) {
        inOrderBst(root, k);
        return result;
    }

    private void inOrderBst(TreeNode root, int k) {
        if(root != null) {
            if(result == null){
                inOrderBst(root.left, k);
            }

            count++;
            if(count == k) {
                 result = root.val;
            }
            if(result == null) {
                inOrderBst(root.right, k);
            }

        }
    }

    public static void main(String[] args) {
        P230_KthSmallestBST mainObject = new P230_KthSmallestBST();
        TreeNode node1 = mainObject.new TreeNode(1);
        TreeNode node2 = mainObject.new TreeNode(2);
        TreeNode node3 = mainObject.new TreeNode(3);
        TreeNode node4 = mainObject.new TreeNode(4);
        TreeNode node5 = mainObject.new TreeNode(5);
        TreeNode node6 = mainObject.new TreeNode(6);

        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node2.left = node1;

        System.out.println(mainObject.kthSmallest(node5, 1));
    }

}
