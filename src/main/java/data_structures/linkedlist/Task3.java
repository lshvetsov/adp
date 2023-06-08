package data_structures.linkedlist;

import data_structures.linkedlist.common.ListNode;

public class Task3 {

    private Task3(){}

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

        printLL(node1);
        deleteNode(node3);
        printLL(node1);
    }

    public static void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }

    private static void printLL(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

}
