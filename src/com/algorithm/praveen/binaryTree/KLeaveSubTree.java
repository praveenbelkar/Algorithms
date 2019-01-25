package com.algorithm.praveen.binaryTree;

/**
 * Given a binary tree print the node with subtree which has k number of leaves
 */
public class KLeaveSubTree {

    public int kLeaveSubTree(Node node, int k) {
        if(node == null){
            return 0;
        }
        if(isLeaf(node)) {
            return 1;
        }
        int leftLeaves = kLeaveSubTree(node.left, k);
        int rightLeaves = kLeaveSubTree(node.right, k);
        if(leftLeaves + rightLeaves == k) {
            System.out.println(node);
        }
        return leftLeaves + rightLeaves;
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        KLeaveSubTree mainObject = new KLeaveSubTree();
        Node root = constructTree1();
        mainObject.kLeaveSubTree(root, 4);
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
