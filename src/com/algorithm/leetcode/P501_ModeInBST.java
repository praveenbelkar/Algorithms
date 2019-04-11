package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * Given BST [1,null,2,2],

        1
        \
        2
       /
      2
 return [2].
 Note: If a tree has more than one mode, you can return them in any order.
 */
public class P501_ModeInBST {

    public class TreeNode {
      int val;
      int val1;
      TreeNode left;
      TreeNode right;
      TreeNode(int x,int y) { val = x; val1 = y;}
        @Override
        public String toString() {
            return  val + "." + val1;
        }
    }

    TreeNode prev = null;
    List<Integer> maxOccuringElements = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        TreeNode prev = null;

        inOrder(root, 0, 0);
        int[] arrayMaxOccuringElements = new int[maxOccuringElements.size()];
        int index = 0;
        for(Integer element: maxOccuringElements) {
            arrayMaxOccuringElements[index++]=element;
        }
        return arrayMaxOccuringElements;
    }

    private void inOrder(TreeNode current, int count, int maxCountSoFar) {
        if(current != null) {
            inOrder(current.left, count, maxCountSoFar);

            if(prev == null || current.val == prev.val) {
                count++;
                if(count > maxCountSoFar) {
                    maxCountSoFar = count;
                    maxOccuringElements = new ArrayList<>();
                    maxOccuringElements.add(current.val);
                } else if(count == maxCountSoFar) {
                    maxOccuringElements.add(current.val);
                }
            }
            prev = current;

            inOrder(current.right, count, maxCountSoFar);
        }
    }

    public static void main(String[] args) {
        P501_ModeInBST mainObject = new P501_ModeInBST();
        TreeNode node1 = mainObject.new TreeNode(1,1);
        TreeNode node2_1 = mainObject.new TreeNode(2,1);
        TreeNode node2_2 = mainObject.new TreeNode(3,2);
        //TreeNode node3_1 = mainObject.new TreeNode(3,1);

        TreeNode singleNode = mainObject.new TreeNode(2,1);

        node1.right = node2_1;
        node2_1.left = node2_2;
        //node2_2.left = node3_1;

        int[] result = mainObject.findMode(singleNode);
        Arrays.stream(result).forEach(element -> System.out.print(element + " "));
        //System.out.println(Integer.MAX_VALUE);
    }
}
