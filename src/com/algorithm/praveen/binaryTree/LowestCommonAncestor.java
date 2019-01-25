package com.algorithm.praveen.binaryTree;

public class LowestCommonAncestor {

    public Node lca(Node node, Node alpha, Node beta) {
        if(node == null) {
            return null;
        }

        if(node.data == alpha.data || node.data == beta.data) {
            return node;
        }

        Node a = lca(node.left, alpha, beta);
        Node b = lca(node.right, alpha,beta);
        boolean c = (a != null);
        boolean d = (b != null);

        if(c ^ d) {
            return (a != null ? a : b);
        } else if(c & d) {
            return node;
        } else {
            return null;
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

        NodeUtils.printTree(node1);
        LowestCommonAncestor mainObject = new LowestCommonAncestor();
        Node node = mainObject.lca(node1, node5, node6);
        System.out.println(node);

    }
}
