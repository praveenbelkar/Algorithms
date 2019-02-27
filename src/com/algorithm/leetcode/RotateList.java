package com.algorithm.leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/rotate-list/
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.

 Example 1:

 Input: 1->2->3->4->5->NULL, k = 2
 Output: 4->5->1->2->3->NULL
 Explanation:
 rotate 1 steps to the right: 5->1->2->3->4->NULL
 rotate 2 steps to the right: 4->5->1->2->3->NULL
 Example 2:

 Input: 0->1->2->NULL, k = 4
 Output: 2->0->1->NULL
 Explanation:
 rotate 1 steps to the right: 2->0->1->NULL
 rotate 2 steps to the right: 1->2->0->NULL
 rotate 3 steps to the right: 0->1->2->NULL
 rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList {

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(k <= 0 || head == null) {
            return head;
        }
        int sizeOfList = getSizeOfList(head);
        if(k == sizeOfList || sizeOfList == 1) {
            return head;
        }
        if(k > sizeOfList) {
            k = k % sizeOfList;
            if(k == 0) {
                return head;
            }
        }
        ListNode kMinus1ElementFromEnd = getKMinus1ElementFromEnd(head, k);
        ListNode kthElementFromEnd = kMinus1ElementFromEnd.next;
        kMinus1ElementFromEnd.next = null;
        ListNode lastNode = getLastNode(kthElementFromEnd);
        lastNode.next = head;
        return kthElementFromEnd;
    }

    private ListNode getLastNode(ListNode kthElementFromEnd) {
        ListNode temp = kthElementFromEnd;
        while(temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    private ListNode getKMinus1ElementFromEnd(ListNode head, int k) {
        int cnt = 0;
        ListNode temp1 = head;
        while(cnt < k) {
            temp1 = temp1.next;
            cnt++;
        }
        ListNode temp2 = head;
        while(temp1.next != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp2;
    }

    private int getSizeOfList(ListNode head) {
        ListNode temp = head;
        int cnt = 0;
        while(temp != null) {
            temp = temp.next;
            cnt++;
        }
        return cnt;
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
        RotateList mainObject = new RotateList();
        /*ListNode head = mainObject.createList(new int[]{1,2,3,4,5});
        printList(head);
        System.out.println("-------------------");
        ListNode newHead = mainObject.rotateRight(head, 2);
        printList(newHead);*/

        /*ListNode head = mainObject.createList(new int[]{0,1,2});
        printList(head);
        System.out.println("-------------------");
        ListNode newHead = mainObject.rotateRight(head, 3);
        printList(newHead);*/

        /*ListNode head = mainObject.createList(new int[]{1});
        printList(head);
        System.out.println("-------------------");
        ListNode newHead = mainObject.rotateRight(head, 99);
        printList(newHead);*/

        ListNode head = mainObject.createList(new int[]{1,2,3,4,5});
        printList(head);
        System.out.println("-------------------");
        ListNode newHead = mainObject.rotateRight(head, 10);
        printList(newHead);
    }
}
