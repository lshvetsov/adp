package data_structures.linkedlist;

import data_structures.linkedlist.common.LLPrinter;
import data_structures.linkedlist.common.ListNode;
import java.util.*;

public class Task5 {

    public static void main(String[] args) {

        ListNode a4 = new ListNode(5);
        ListNode a2 = new ListNode(4, a4);
        ListNode a1 = new ListNode(1, a2);

        ListNode b3 = new ListNode(4);
        ListNode b2 = new ListNode(3, b3);
        ListNode b1 = new ListNode(1, b2);

        ListNode c2 = new ListNode(6);
        ListNode c1 = new ListNode(2, c2);

        ListNode d4 = new ListNode(-1);
        ListNode d3 = new ListNode(-1, d4);
        ListNode d2 = new ListNode(-1, d3);
        ListNode d1 = new ListNode(-2, d2);

        ListNode result = mergeKLists(new ListNode[]{a1,b1,c1});
        System.out.println("Case1");
        LLPrinter.printLL(result);

        ListNode result2 = mergeKLists(new ListNode[]{});
        System.out.println("Case2");
        LLPrinter.printLL(result2);

        ListNode result3 = mergeKLists(new ListNode[]{null, new ListNode(1)});
        System.out.println("Case3");
        LLPrinter.printLL(result3);

        ListNode result4 = mergeKLists(null);
        System.out.println("Case4");
        LLPrinter.printLL(result4);

        ListNode result5 = mergeKLists(new ListNode[]{null});
        System.out.println("Case5");
        LLPrinter.printLL(result5);

        ListNode result6 = mergeKLists(new ListNode[]{d1, null});
        System.out.println("Case6");
        LLPrinter.printLL(result6);

    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt((ListNode n) -> n.val));

        for (ListNode node:lists) {
            if (node == null) continue;
            while (node.next != null) {
                queue.add(node);
                node = node.next;
            }
            queue.add(node);
        }

        ListNode result = queue.poll();
        ListNode current = result;

        Iterator<ListNode> iterator = queue.iterator();

        while (iterator.hasNext()) {
            current.next = queue.poll();
            current = current.next;
        }

        if (current != null) current.next = null;

        return result;
    }

}
