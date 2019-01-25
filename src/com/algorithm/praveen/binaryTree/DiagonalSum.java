package com.algorithm.praveen.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree calculate the sum of each diagonal
 */
public class DiagonalSum {

    private static class Result {
        List<Node> diagonalNodes;
        int sum;

        public Result(List<Node> diagonalNodes, int sum) {
            this.diagonalNodes = diagonalNodes;
            this.sum = sum;
        }
    }

    public Map<Integer, Result> getDiagonalSum(Node root){
        Map<Integer, Result> resultMap = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Node> diagonalNodeList = new ArrayList<>();
        //diagonalNodeList.add(root);
        int diagonalIndex = 0;
        int sum = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node == null){//End of diagonal
                Result result = new Result(diagonalNodeList, sum);
                diagonalIndex = diagonalIndex+1;
                resultMap.put(diagonalIndex, result);
                diagonalNodeList = new ArrayList<>();
                sum = 0;

                queue.add(null);
                node = queue.poll();
                if(node == null) { //End of queue
                    break;
                }
            }

            while(node != null){
                sum += node.data;
                diagonalNodeList.add(node);

                if(node.left != null){
                    queue.add(node.left);
                }
                node = node.right;
            }
        }

        return resultMap;
    }

    public static void main(String[] args) {
        DiagonalSum mainObject = new DiagonalSum();
        Node root = constructTree1();
        Map<Integer, Result> resultMap = mainObject.getDiagonalSum(root);
        //Expected
        //1: 11
        //2: 13
        //3:  4
        resultMap.forEach((k,v) -> {
            System.out.println(k +" : " + v.sum);
            v.diagonalNodes.stream().forEach(System.out::print);
            System.out.println();
        });
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
