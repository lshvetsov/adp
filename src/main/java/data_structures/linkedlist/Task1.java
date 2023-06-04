package data_structures.linkedlist;

public class Task1 {

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
