package com.algorithm.praveen.binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class NodeUtils {

    public static void constructTree(){

    }

    public static void printTree(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue = new LinkedBlockingDeque<>();
        queue.add(root);
        Node specialNode = new Node(Integer.MIN_VALUE);
        queue.add(specialNode);
        Node temp = null;

        System.out.println("--------------------");
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if(specialNode != temp) {
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
                System.out.println(temp);
            } else if (!queue.isEmpty()){
                queue.add(specialNode);
            }
        }
        System.out.println("--------------------");
    }

    public static boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null ;
    }
}
