package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class P92_ReverseRangeLinkedList {

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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int cnt = 1;
        ListNode cur = head;
        ListNode prev = null;
        while(cnt < m) {
            prev = cur;
            cur = cur.next;
            cnt++;
        }

        ListNode reversedList = reverseList(cur, n - m + 1);
        if(prev != null) {
            prev.next = reversedList;
        } else {
            return reversedList;
        }

        return  head;
    }

    public ListNode reverseList(ListNode start, int numberOfNodes) {
        ListNode cur = start;
        int count = 1;
        ListNode prev = null;
        ListNode temp = null;
        while(count <= numberOfNodes) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            count++;
        }
        start.next = cur;
        return prev;
    }

    public static void main(String[] args) {
        P92_ReverseRangeLinkedList mainObject = new P92_ReverseRangeLinkedList();
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode node7 = new ListNode(7, null);
        ListNode node6 = new ListNode(6, node7);

        ListNode head = mainObject.reverseBetween(node6, 1,2);
        //ListNode head = mainObject.reverseList(node1, 6);
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
