package com.algorithm.praveen.binaryTree;

/**
 * Given a binary tree find the length of diameter of the tree
 */
public class Diameter {

    public int diameter(Node node) {
        if(node == null){
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int longestPathThroughNode = leftHeight + rightHeight + 1;
        int longestPathNotThroughNode = Math.max(diameter(node.left), diameter(node.right));
        return Math.max(longestPathThroughNode, longestPathNotThroughNode);
    }

    private int height(Node node) {
        if(node == null) {
            return 0;
        }
        return Math.max(height(node.left), height((node.right))) + 1;
    }

    public static void main(String[] args) {
        Diameter mainObject = new Diameter();
        Node root = constructTree1();
        System.out.println(mainObject.diameter(root));
    }

    private static Node constructTree1() {
        //      1
        //    2     3
        //  4  5   6  7
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        return node1;
    }

}
