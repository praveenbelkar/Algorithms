package com.algorithm.leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * Remove all elements from a linked list of integers that have value val.
 Example:
 Input:  1->2->6->3->4->5->6, val = 6
 Output: 1->2->3->4->5
 */
public class P203_RemoveLinkedListElements {

   public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

       @Override
       public String toString() {
           return val + "";
       }
   }

   public ListNode removeElements(ListNode head, int val) {
       if(null == head) {
           return head;
       }
       ListNode prev = head;
       ListNode cur = head;
       while(cur != null) {
           if(cur.val == val) {
               while(cur != null && cur.val == val) {
                   cur = cur.next;
               }
               prev.next = cur;
           }
           prev = cur;
           if(cur != null) {
               cur = cur.next;
           }
       }

       //Remove elements from begining
       cur = head;
       while(cur != null && cur.val == val) {
           ListNode temp = cur;
           cur = cur.next;
           temp = null;
       }
       head = cur;
       return head;
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
        P203_RemoveLinkedListElements mainObject = new P203_RemoveLinkedListElements();
        /*ListNode head = mainObject.createList(new int[]{6,6,2,6,3,4,5,6});
        printList(head);
        System.out.println("-------------------");
        ListNode newHead = mainObject.removeElements(head, 6);
        printList(newHead);*/

        ListNode head = mainObject.createList(new int[]{2,2,2});
        printList(head);
        System.out.println("-------------------");
        ListNode newHead = mainObject.removeElements(head, 2);
        printList(newHead);
    }
}
