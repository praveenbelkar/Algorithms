package com.algorithm.praveen.list;

public class ListUtil {

    public static Node getListWithValues(int...values) {
        Node head = Node.getNode(values[0]);
        Node current = head;
        for(int i=1; i < values.length; i++) {
            Node node = Node.getNode(values[i]);
            current.next = node;
            current = node;
        }
        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        int i = 0;
        while(current != null) {
            if(i != 0){
                System.out.print("-->");
            }
            System.out.print(current.data);
            current = current.next;
            i++;
        }
        System.out.println();
    }
}
