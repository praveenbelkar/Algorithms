package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
          3
         / \
        9  20
          /  \
        15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class P107_BinaryTreeLevelOrder_II {

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) {
            return results;
        }
        queue.add(root);
        queue.add(null);
        List<Integer> levelNumbers = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null) {
                if(queue.isEmpty()) {
                    results.add(0,levelNumbers);
                    break;
                }
                queue.add(null);
                results.add(0,levelNumbers);
                levelNumbers = new ArrayList<>();
                continue;
            }
            levelNumbers.add(node.val);

            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        P107_BinaryTreeLevelOrder_II mainObject = new P107_BinaryTreeLevelOrder_II();
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

        List<List<Integer>> results = mainObject.levelOrderBottom(node1);
        for(List<Integer> list: results) {
            list.stream().forEach(element -> System.out.print(element + " "));
            System.out.println();
        }
    }
}
