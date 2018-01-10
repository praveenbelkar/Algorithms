package com.algorithm.praveen.binaryTree;

public class Node {

    public Node left;
    public Node right;
    public int data;

    public static boolean isLeaf(Node node) {
        return (node.left == null || node.right == null);
    }

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
