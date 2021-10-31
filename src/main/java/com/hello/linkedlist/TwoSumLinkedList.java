package com.hello.linkedlist;

import java.math.BigInteger;

public class TwoSumLinkedList {

    public static void main(String args[]) {
        new TwoSumLinkedList();
    }

    static ListNode getListNodeFromArray(int[] arr) {
        ListNode next = null;
        for (int i=arr.length-1; i>=0; i--) {
            ListNode node = new ListNode(arr[i]);
            node.next = next;
            next = node;
        }
        return next;
    }

    public TwoSumLinkedList() {
//[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
//[5,6,4]
        ListNode result = addTwoNumbers(getListNodeFromArray(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}),
                getListNodeFromArray(new int[]{5, 6, 4}));
        System.out.println(getNumFromList(result));
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int i = 0;
        String num1 = getNumFromList(l1);
        String num2 = getNumFromList(l2);
        System.out.println("A:" + num1);
        System.out.println("B:" + num2);

        num1 = reverseString(num1);
        BigInteger b1 = new BigInteger(num1);

        num2 = reverseString(num2);
        BigInteger b2 = new BigInteger(num2);

        BigInteger result = b1.add(b2);
        System.out.println("sum:" + result);
        String resultStr = "" + result;
        String nodeStr = reverseString(resultStr);

        ListNode firstNode = null;
        ListNode previousNode = null;
        for (int j = 0; j < nodeStr.length(); j++) {
            ListNode node = new ListNode(Integer.parseInt("" + nodeStr.charAt(j)));
            System.out.println("" + nodeStr.charAt(j));
            if (firstNode == null) {
                firstNode = node;
                previousNode = node;
            } else {
                previousNode.next = node;
                previousNode = node;
            }
        }
        return firstNode;

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


    private String getNumFromList(ListNode start) {
        ListNode current = start;
        String num = "";
        do {
            num += "" + current.val;
            current = current.next;
        } while (current != null && current.next != null);
        if (current != null) {
            num += "" + current.val;
        }
        return num;
    }

    private String reverseString(String str) {
        byte[] bytes = str.getBytes();
        byte[] result = new byte[str.length()];
        for (int i = 0; i < bytes.length; i++) {
            result[i] = bytes[bytes.length - i - 1];
        }
        return new String(result);
    }


}


