package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 Example 1:

 Input: 1->1->2
 Output: 1->2
 Example 2:

 Input: 1->1->2->3->3
 Output: 1->2->3
 *
 */
public class P83_RemoveDuplicateFromSortedList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode returnHead = head;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            while(next != null && cur.val == next.val) {
                next = next.next;
            }
            cur.next = next;
            cur = next;
        }
        return returnHead;
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
        P83_RemoveDuplicateFromSortedList mainObject = new P83_RemoveDuplicateFromSortedList();
        ListNode head = mainObject.createList(new int[]{1,2,2,3,3});
        printList(head);
        System.out.println("-------------------");
        ListNode returnHead = mainObject.deleteDuplicates(head);
        printList(returnHead);
    }
}
