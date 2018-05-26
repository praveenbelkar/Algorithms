package com.algorithm.praveen.list;

public class ReverseListRecursion {

    public static Node reversedHead = null;

    public void reverseList(Node head) {
        reverse(head);
        head.next = null;
    }

    public Node reverse(Node current) {
        if(current.next == null) {
            reversedHead = current;
            return current;
        }
        Node next = reverse(current.next);
        next.next = current;
        return current;
    }

    public static void main(String[] args) {
        ReverseListRecursion mainObject = new ReverseListRecursion();
        Node head = ListUtil.getListWithValues(1, 3, 5);
        ListUtil.printList(head);
        mainObject.reverseList(head);
        ListUtil.printList(reversedHead);
    }
}
