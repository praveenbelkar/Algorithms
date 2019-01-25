package com.algorithm.praveen.binaryTree;

import java.util.LinkedList;

/**
 * Given a binary tree print its diagonal elements
 */
public class DiagonalNodes {

    public void printDiagonalNodes(Node root) {

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node == null){ //When node is null, it means end of diagonal
                System.out.println();
                queue.add(null);
                node = queue.poll();
                if(node == null){ //Check for empty queue
                    break;
                }
            }

            while(node != null){
                System.out.print(node + "-->");
                ifLeftNodePresentAddToQueue(node, queue);
                node = node.right;
            }
        }
    }

    private void ifLeftNodePresentAddToQueue(Node node, LinkedList<Node> queue) {
        if(node.left != null){
            queue.add(node.left);
        }
    }

    public static void main(String[] args) {
        DiagonalNodes mainObject = new DiagonalNodes();
        Node root = constructTree1();
        //Expected
        //1->3->7
        //2->5->6
        //4

        mainObject.printDiagonalNodes(root);
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
