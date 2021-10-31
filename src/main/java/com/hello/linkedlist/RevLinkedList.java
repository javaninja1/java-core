package com.hello.linkedlist;


public class RevLinkedList {

    public static void main(String args[]) {
        new RevLinkedList();
    }

    // {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2}
    public RevLinkedList() {
        int[] arr = {}; // {1,0,0,0,0,33,44,55,0,0,0,2}; //{5,6,7};
        ListNode head = listFromArr(arr);
        printList(head);
        ListNode result = reverseList(head);
        printList(result);
    }

    private void printList(ListNode result) {
        System.out.println("~~~~~~~List~~~~~~");
        if (result != null) {
            while (result.next != null) {
                System.out.print(result.val + "->");
                result = result.next;
            }
            System.out.println(result.val);
        }
    }

    private ListNode listFromArr(int[] arr) {
        ListNode next = null;
        for (int i=arr.length-1; i>=0; i--) {
            ListNode node = new ListNode(arr[i]);
            node.next = next;
            next = node;
        }
        return next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev=null, cur = head, next = null;
        if (cur != null ) {
            while (cur.next != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            cur.next = prev;
        }
        return cur;
    }






    }




