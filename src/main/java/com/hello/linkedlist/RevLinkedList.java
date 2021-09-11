package com.hello.linkedlist;

public class RevLinkedList {

    public static void main(String args[]) {
        new RevLinkedList();
    }

    public RevLinkedList() {
//[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
//[5,6,4]
        ListNode result = reverseList(TwoSumLinkedList.getListNodeFromArray(new int[]{5, 6, 4}));
        System.out.println(result);
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;
        //[1,2,3,4,5]
        if (current != null) {
            while (current.next != null) {
                next = current.next; // 2
                current.next = previous; // null
                previous = current; // 1
                current = next; //2
            }
            current.next = previous;
        }

        return current;

    }


}


