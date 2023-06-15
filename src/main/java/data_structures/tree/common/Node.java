package data_structures.tree.common;

public class Node {
    public int item;
    public Node left, right;

    public Node(int key) {
        item = key;
        left = right = null;
    }
}
