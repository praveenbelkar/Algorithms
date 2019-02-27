package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * Write a function to delete a node (except the tail)
 * in a singly linked list, given only access to that node.
 *
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should
 * become 4 -> 1 -> 9 after calling your function.
 */
public class P237_DeleteNodeLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        if(node == null) {
            return;
        }
        if(node.next == null) {
            return;
        }
        ListNode next = node.next;

        //Copy contents of next into current node
        node.val = next.val;
        node.next = next.next;

        //Delete next node
        next = null;
    }

    private ListNode createList(int[] array) {
        ListNode prev = new ListNode(array[0]);
        ListNode head = prev;
        for(int i=1; i <= array.length-1; i++) {
            ListNode node = new ListNode(array[i]);
            prev.next = node;
            prev = node;
        }
        prev.next = null;
        return head;
    }

    private static void printList(ListNode node) {
        ListNode temp = node;
        while(temp != null) {
            System.out.print(temp.val + " ->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        P237_DeleteNodeLinkedList mainObject = new P237_DeleteNodeLinkedList();
        ListNode head = mainObject.createList(new int[]{1,2,3,4,5});
        printList(head);
        System.out.println("-------------------");
        ListNode deleteNode = head;//head.next.next.next;
        mainObject.deleteNode(deleteNode);
        printList(head);
    }
}
