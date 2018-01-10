package com.algorithm.praveen.binaryTree;

import java.util.Arrays;

public class PathWithGivenSum {

    public void printPathWithGivenSum(Node node, Node[] path, int index, int sum, int currentSum) {
        if(node == null) {
            return;
        }

        path[index] = node;
        currentSum = getPathSum(path, index);
        if(Node.isLeaf(node)) {
            if(currentSum == sum) {
                printNodes(path, index);
            }
        }
        printPathWithGivenSum(node.left, path, index + 1, sum, currentSum);
        printPathWithGivenSum(node.right, path, index + 1, sum, currentSum);
    }

    private void printNodes(Node[] path, int index) {
        for(int i = 0; i <= index; i++) {
            System.out.println(path[i].data);
        }
    }

    private int getPathSum(Node[] path, int index) {
        int sum = 0 ;
        for(int i = 0; i <= index; i++) {
            sum += path[i].data;
        }
        return sum;
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        NodeUtils.printTree(node1);
        PathWithGivenSum mainObject = new PathWithGivenSum();
        Node[] path = new Node[7];
        mainObject.printPathWithGivenSum(node1, path, 0, 7, 0);

    }
}
