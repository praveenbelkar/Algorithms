package com.algorithm.leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListWithinGivenPosition {

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return  val + "";
        }
    }

    private static class Container{
        ListNode start;
        ListNode end;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 1;
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = cur.next;
        while(count != m) {
            count++;
            prev = cur;
            cur = cur.next;
        }

        Container reversedList = reverse(cur, n);
        prev.next = reversedList.end;
        reversedList.start.next = cur;
        return head;
    }

    private Container reverse(ListNode cur, int n) {
        Container result = new Container();
        result.start = cur;

        ListNode prev = null;
        ListNode next = cur.next;
        int count = 1;
        while(count < n) {
            //ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            next = cur.next;
            count++;
        }
        result.end = prev;

        ListNode temp = result.end;
        System.out.println("------------");
        while(temp != result.start) {
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println("------------");
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printList(node1);
        ReverseLinkedListWithinGivenPosition mainObject = new ReverseLinkedListWithinGivenPosition();
        mainObject.reverseBetween(node1, 2, 4);
        printList(node1);
    }

    public static void printList(ListNode node1) {
        ListNode temp = node1;
        int cnt = 0;
        while(temp != null) {
            if(cnt != 0) {
                System.out.print("-->");
            }
            System.out.print(temp.val);
            cnt++;
            temp = temp.next;
        }
        System.out.println();
    }
}
