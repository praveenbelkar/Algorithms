package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Input: [1,null,2,3]
           1
            \
            2
           /
          3

 Output: [1,3,2]

         5
        / \
       3   6
      / \
    2   4
    /
    1
 */
public class P94_BinaryTreeInOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> result) {
        if(root != null) {
            inOrder(root.left, result);
            result.add(root.val);
            inOrder(root.right, result);
        }
    }

    public static void main(String[] args) {
        P94_BinaryTreeInOrder mainObject = new P94_BinaryTreeInOrder();
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

        List<Integer> result = mainObject.inorderTraversal(node5);
        result.stream().forEach(element -> System.out.print(element + " "));
    }

}
