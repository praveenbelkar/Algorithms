package com.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 * Given a binary tree, find the leftmost value in the last row of the tree.

 Example 1:
 Input:

   2
  / \
 1   3

 Output:
 1

 Example 2:
 Input:

        1
        / \
        2   3
        /   / \
        4   5   6
            /
            7

 Output:
 7
 */
public class P513_BottomLeftTreeValue {

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

    private int maxLevel = Integer.MIN_VALUE;

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean firstElementInThisLevel = true;
        int bottomLeftValue = root.val;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) { // level change
                if(queue.isEmpty()) {
                    break;
                }
                queue.add(null);
                firstElementInThisLevel = true;
                continue;
            }

            if(firstElementInThisLevel) {
                bottomLeftValue = node.val;
                firstElementInThisLevel = false;
            }

            if(node.left != null) {
                queue.add(node.left);
            }

            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return bottomLeftValue;
    }

    public static void main(String[] args) {
        P513_BottomLeftTreeValue mainObject = new P513_BottomLeftTreeValue();
        /*TreeNode root = mainObject.new TreeNode(2);
        TreeNode node1 = mainObject.new TreeNode(1);
        TreeNode node2 = mainObject.new TreeNode(3);
        root.left = node1;
        root.right = node2;*/

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
        node3.left = node5;
        node3.right = node6;
        node5.left = node7;

        TreeNode emptyNode = mainObject.new TreeNode(4);
        System.out.println(mainObject.findBottomLeftValue(emptyNode));
    }
}
