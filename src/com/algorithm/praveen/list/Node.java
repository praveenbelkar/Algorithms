package com.algorithm.praveen.list;

public class Node {

    public int data;
    public Node next;

    public static Node getNode(int data) {
        Node node = new Node();
        node.data = data;
        return node;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
