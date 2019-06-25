package com.algorithm.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 */
public class P257_BinaryTreePaths {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        binaryTreePathUtil(root, result, queue);
        return result;
    }

    public void binaryTreePathUtil(TreeNode node, List<String> result, LinkedList<Integer> queue) {
        if(node != null) {
            queue.addLast(node.val);
            if(node.left == null && node.right == null) {
                String path = printQueue(queue);
                result.add(path);
                queue.removeLast();
                return;
            }
            binaryTreePathUtil(node.left, result, queue);
            binaryTreePathUtil(node.right, result, queue);
            queue.removeLast();
        }
    }

    private String printQueue(LinkedList<Integer> queue) {
        Iterator<Integer> it = queue.iterator();
        StringBuilder sb = new StringBuilder();
        if(it.hasNext()) {
            sb.append(it.next());
        }

        while (it.hasNext()) {
            sb.append("->").append(it.next());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        P257_BinaryTreePaths mainObject = new P257_BinaryTreePaths();

    }
}
