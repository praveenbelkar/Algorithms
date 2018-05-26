package com.algorithm.praveen.binaryTree;

//Check if the given binary tree is mirror image around the root node
public class CheckMirror {

    public boolean checkIfMirror(Node left, Node right) {
        if(onlyOneOfThemIsNull(left, right) || bothAreNotEqual(left,right) ) {
            return false;
        }
        return bothAreNull(left, right) ||
                (bothAreEqual(left, right) && checkIfMirror(left.left, right.right) && checkIfMirror(left.right, right.left));
    }

    private boolean bothAreNotEqual(Node left, Node right) {
        return (left != null & right != null) && (left.data != right.data);
    }

    private boolean bothAreEqual(Node left, Node right) {
        return left.data == right.data;
    }

    private boolean bothAreNull(Node left, Node right) {
        return null == left && null == right;
    }

    private boolean onlyOneOfThemIsNull(Node left, Node right) {
        return (left == null && right != null) || (left != null && right == null);
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
