package com.algorithm.praveen.list;

public class ReverseLinkedList {

    public Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = current.next;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node node = ListUtil.getListWithValues(new int[]{1,2,3, 4});
        ReverseLinkedList mainObject = new ReverseLinkedList();
        node = mainObject.reverse(node);
        ListUtil.printList(node);
    }
}
