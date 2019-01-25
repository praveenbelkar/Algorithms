package com.algorithm.bytebybyte;


import com.algorithm.praveen.binaryTree.Node;

/**
 * https://www.byte-by-byte.com/treetolist
 * Given a tree write a function to convert it to circular doubly linked list from left to right
 */
public class TreeToDoublyLinkedList {

    Node head = null;
    Node prev = null;

    public void treeToDoublyLinkedList(Node node) {

/*
        if(node == null){
            if(head == null){
                head = prev;
            }
            return;
        }
*/

        if(node.left != null){
            treeToDoublyLinkedList(node.left);
        } else if( node.left == null && head == null) {
            head = node;
        }

        /*if(prev == null){
            head = node;
        }*/
        System.out.println(node.data);
        if(prev != null ){
            prev.right = node;
            node.left = prev;
        }
        prev = node;

        if(node.right != null){
            treeToDoublyLinkedList(node.right);
        }

    }

    public static void main(String[] args) {
        TreeToDoublyLinkedList mainObject = new TreeToDoublyLinkedList();
        Node root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        mainObject.treeToDoublyLinkedList(root);

        Node node = mainObject.head;
        while(node != null) {
            System.out.print(node + " -->");
            node = node.right;
        }
    }
}
