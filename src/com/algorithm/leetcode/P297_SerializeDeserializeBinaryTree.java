package com.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P297_SerializeDeserializeBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return     "val=" + val;
        }
    }

    public String serialize(TreeNode root) {
        String value = serializeUtil(root, "");
        value = value.substring(0, value.length()-1);
        return value;
    }

    private String serializeUtil(TreeNode root, String value) {
        if(root == null) {
            return "null,";
        }
        value =  root.val + ",";
        String left = serializeUtil(root.left, value);
        String right = serializeUtil(root.right, value);
        value = value + left + right;
        return value;
    }

    private TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        Deque<String> deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList(dataArray));
        return deserializeUtil(deque);
    }

    private TreeNode deserializeUtil(Deque<String> deque) {

        String val = deque.poll();
        if(val.equals("null")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(val));
        treeNode.left = deserializeUtil(deque);
        treeNode.right = deserializeUtil(deque);
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        P297_SerializeDeserializeBinaryTree mainObject = new P297_SerializeDeserializeBinaryTree();
        String serializedValue = mainObject.serialize(treeNode1);
        System.out.println(serializedValue);
        TreeNode treeNode = mainObject.deserialize(serializedValue);
        //printTree(treeNode);
        System.out.println(mainObject.serialize(treeNode));

    }

}
