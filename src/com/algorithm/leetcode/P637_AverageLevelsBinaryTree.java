package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 *
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 Example 1:
 Input:
     3
    / \
   9  20
     /  \
    15   7
 Output: [3, 14.5, 11]
 */
public class P637_AverageLevelsBinaryTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int nodesInCurrentLevel = 1;
        Double currentLevelSum = new Double(root.val);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {
                if(queue.isEmpty()) {
                    result.add(currentLevelSum/nodesInCurrentLevel);
                    currentLevelSum = new Double(0);
                    nodesInCurrentLevel = 0;
                    break;
                }
                result.add(currentLevelSum/nodesInCurrentLevel);
                currentLevelSum = new Double(0);
                nodesInCurrentLevel = 0;
                queue.add(null);
                continue;
            }
            currentLevelSum = currentLevelSum + new Double(node.val);
            nodesInCurrentLevel++;
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        P637_AverageLevelsBinaryTree mainObject = new P637_AverageLevelsBinaryTree();
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
        List<Double> result = mainObject.averageOfLevels(node1);
        result.stream().forEach(element -> System.out.print(element + " "));
    }
}
