package com.algorithm.praveen.binaryTree;

//Check if the given binary tree is mirror image around the root node
public class CheckMirror {

    public boolean checkIfMirror(Node alpha, Node beta) {
        if(onlyOneOfThemIsNull(alpha, beta) || bothAreNotEqual(alpha,beta) ) {
            return false;
        }
        return bothAreNull(alpha, beta) ||
                (bothAreEqual(alpha, beta) && checkIfMirror(alpha.left, beta.right) && checkIfMirror(alpha.right, beta.left));
    }

    private boolean bothAreNotEqual(Node alpha, Node beta) {
        return (alpha != null & beta != null) && (alpha.data != beta.data);
    }

    private boolean bothAreEqual(Node alpha, Node beta) {
        return alpha.data == beta.data;
    }

    private boolean bothAreNull(Node alpha, Node beta) {
        return null == alpha && null == beta;
    }

    private boolean onlyOneOfThemIsNull(Node alpha, Node beta) {
        return (alpha == null && beta != null) || (alpha != null && beta == null);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(5);
        Node node7 = new Node(4);
        Node node8 = new Node(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        CheckMirror mainObject = new CheckMirror();
        boolean result = mainObject.checkIfMirror(node1.left, node1.right);
        System.out.println(result);
    }
}
