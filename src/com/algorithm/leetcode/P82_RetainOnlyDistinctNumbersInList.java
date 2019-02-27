package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 Example 1:

 Input: 1->2->3->3->4->4->5
 Output: 1->2->5
 Example 2:

 Input: 1->1->1->2->3
 Output: 2->3
 */
public class P82_RetainOnlyDistinctNumbersInList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return  val +"";
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode returnHead = head;
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        boolean duplicateFoundInThisIteration = false;
        while(cur != null) {
            next = cur.next;
            duplicateFoundInThisIteration = false;
            while(next != null && cur.val == next.val) {
                cur = null;
                cur = next;
                next = next.next;
                duplicateFoundInThisIteration = true;
            }
            if(duplicateFoundInThisIteration) {
                cur = null;
                cur = next;
            }
            if(prev == null && duplicateFoundInThisIteration) {
                returnHead = cur;
            }
            if(prev == null) {
                prev = cur;
            } else {
                prev.next = cur;
                prev = cur;
            }
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
        P82_RetainOnlyDistinctNumbersInList mainObject = new P82_RetainOnlyDistinctNumbersInList();
        ListNode head = mainObject.createList(new int[]{1,2,2,3,4,4});
        printList(head);
        System.out.println("-------------------");
        ListNode returnHead = mainObject.deleteDuplicates(head);
        printList(returnHead);
    }
}
