package data_structures.linkedlist;

import data_structures.linkedlist.common.ListNode;

public class Task2 {

    private Task2(){}

    public static void main(String[] args) {

        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(4);
        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(5);
        node21.next = node22;
        node22.next = node23;

        ListNode resultNode = mergeTwoLists(node11, node21);
        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        list1.next = Task2.mergeTwoLists(list1.next, list2);

        return list1;

    }

}
