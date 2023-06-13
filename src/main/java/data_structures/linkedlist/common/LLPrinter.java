package data_structures.linkedlist.common;

public class LLPrinter {

    private LLPrinter() {}

    public static void printLL(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

}
