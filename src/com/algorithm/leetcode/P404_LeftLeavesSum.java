package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 *
 * Find the sum of all left leaves in a given binary tree.

 Example:

     3
    / \
   9  20
     /  \
    15   7

 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class P404_LeftLeavesSum {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
        @Override
        public String toString() {
            return  val + "";
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return sumLeftLeaves(root, 0);
    }

    public int sumLeftLeaves(TreeNode node, int sum) {
        if(node == null) {
            return sum;
        }
        if(isLeaf(node.left)) {
            sum = sum + node.left.val;
            return sumLeftLeaves(node.right, sum);
        } else {
            sum = sumLeftLeaves(node.left, sum);
            return sumLeftLeaves(node.right, sum);
        }

    }

    private boolean isLeaf(TreeNode node) {
        return  null != node && node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        P404_LeftLeavesSum mainObject = new P404_LeftLeavesSum();
        TreeNode node3 = mainObject.new TreeNode(3);
        TreeNode node9 = mainObject.new TreeNode(9);
        TreeNode node20 = mainObject.new TreeNode(20);
        TreeNode node15 = mainObject.new TreeNode(15);
        TreeNode node7 = mainObject.new TreeNode(7);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        System.out.println(mainObject.sumOfLeftLeaves(node3));
    }
}
