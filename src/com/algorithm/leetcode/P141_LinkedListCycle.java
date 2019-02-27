package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * Given a linked list, determine if it has a cycle in it.
 * To represent a cycle in the given linked list, we use an
 * integer pos which represents the position (0-indexed) in the
 * linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

 Example 1:

 Input: head = [3,2,0,-4], pos = 1
 Output: true
 Explanation: There is a cycle in the linked list, where tail connects to the second node.
 */
public class P141_LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
            if(slow == fast) {
                return true;
            }
        }
        return false;
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

    private ListNode getLastNode(ListNode head) {
        ListNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        P141_LinkedListCycle mainObject = new P141_LinkedListCycle();
        ListNode head = mainObject.createList(new int[]{1,2,3,4,5,6});
        printList(head);
        System.out.println("-------------------");
        ListNode lastNode = mainObject.getLastNode(head);
        lastNode.next = head.next.next;
        System.out.println(mainObject.hasCycle(head));
    }
}
