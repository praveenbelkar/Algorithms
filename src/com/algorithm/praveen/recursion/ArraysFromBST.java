package com.algorithm.praveen.recursion;
/*
A binary search tree was created by traversing
through an array from left to right and inserting each element. Given a binary tree with
distinct elements, print all possible arrays that could have led to this tree
 */

import com.algorithm.praveen.binaryTree.Node;
import com.algorithm.praveen.binaryTree.NodeUtils;

import java.util.ArrayList;
import java.util.List;

public class ArraysFromBST {

    public List<List<Node>> getPossibleArraysForBST(Node node) {
        //Base condition
        if(NodeUtils.isLeaf(node)) {
            List<List<Node>> result = getResultContainer();
            List<Node> path = new ArrayList<>();
            path.add(node);
            result.add(path);
            return result;
        }

        List<List<Node>> result = getResultContainer();
        List<List<Node>> leftResult = (node.left != null) ? getPossibleArraysForBST(node.left): new ArrayList<>();
        List<List<Node>> rightResult = (node.right != null) ? getPossibleArraysForBST(node.right): new ArrayList<>();

        result = getCrossProductofLists(node, result, leftResult, rightResult);
        result = getCrossProductofLists(node, result, rightResult, leftResult);

        return result;
     }

    private List<List<Node>> getCrossProductofLists(Node node, List<List<Node>> result, List<List<Node>> leftResult, List<List<Node>> rightResult) {
        for(List<Node> leftList: leftResult) {
            for(List<Node> rightList: rightResult) {
                List<Node> combination1 = new ArrayList<>();
                combination1.add(node);
                combination1.addAll(leftList);
                combination1.addAll(rightList);
                result.add(combination1);
            }
        }
        return result;
    }

    private List<List<Node>> getResultContainer() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ArraysFromBST mainObject = new ArraysFromBST();
        Node node1 = new Node(20);
        Node node2 = new Node(10);
        Node node3 = new Node(30);
        Node node4 = new Node(5);
        Node node5 = new Node(15);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        /*Node node1 = new Node(10);
        Node node2 = new Node(5);
        Node node3 = new Node(15);
        node1.left = node2;
        node1.right = node3;*/

        List<List<Node>> result = mainObject.getPossibleArraysForBST(node1);
        System.out.println(result.size());
        for(List<Node> list: result) {
            System.out.println();
            for(Node element: list) {
                System.out.print(element.data + " ");
            }

        }
    }
}
