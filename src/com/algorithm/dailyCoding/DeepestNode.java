package com.algorithm.dailyCoding;

import com.algorithm.praveen.binaryTree.Node;
import com.algorithm.praveen.binaryTree.NodeUtils;

import static com.algorithm.praveen.binaryTree.NodeUtils.isLeaf;

/**
 * Given the root of a binary tree, return a deepest node.
 */
public class DeepestNode {

    int maxLevel = 0;
    Node deepestNode = null;

    public void getDeepestNode(Node node, int level) {
        if(node != null) {
            if(isLeaf(node)) {
                if(level > maxLevel) {
                    maxLevel = level;
                    deepestNode = node;
                }
            } else {
                if(node.left != null) {
                    getDeepestNode(node.left, level+1);
                }
                if(node.right != null) {
                    getDeepestNode(node.right, level+1);
                }
            }
        }
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
        node7.right = node8;

        DeepestNode mainObject = new DeepestNode();
        mainObject.getDeepestNode(node1, 0);
        System.out.println(mainObject.deepestNode.data);
    }

}
