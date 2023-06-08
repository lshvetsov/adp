package data_structures.linkedlist;

import data_structures.linkedlist.common.ListNode;

public class Task1 {

    private Task1(){}

    public static ListNode reverseList (ListNode head) {

        ListNode previous = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }

        return previous;
    }

}
