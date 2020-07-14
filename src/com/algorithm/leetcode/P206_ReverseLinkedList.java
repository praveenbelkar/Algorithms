package com.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class P206_ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public String toString() {
            return String.valueOf(val);
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode temp = null;
        ListNode prev = null;

        while(cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>();
        
        return prev;
    }

    public static void main(String[] args) {
        P206_ReverseLinkedList mainObject = new P206_ReverseLinkedList();
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode node7 = new ListNode(7, null);
        ListNode node6 = new ListNode(6, node7);

        ListNode head = mainObject.reverseList(node7);
        printList(head);
    }

    private static void printList(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.val + "-->");
            cur = cur.next;
        }
    }

}
