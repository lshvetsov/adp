package data_structures.linkedlist;

import data_structures.linkedlist.common.NestedInteger;
import data_structures.linkedlist.common.NestedIntegerImpl;

import java.util.*;

public class Task4 {

    private Task4(){}

    public static void main(String[] args) {

        NestedInteger n1 = new NestedIntegerImpl(1, null);
        NestedInteger n2 = new NestedIntegerImpl(2, null);
        NestedInteger n3 = new NestedIntegerImpl(3, null);
        NestedInteger n4 = new NestedIntegerImpl(4, null);
        NestedInteger n5 = new NestedIntegerImpl(5, null);
        NestedInteger n6 = new NestedIntegerImpl(6, null);
        NestedInteger n7 = new NestedIntegerImpl(7, null);
        NestedInteger n8 = new NestedIntegerImpl(8, null);
        NestedInteger n9 = new NestedIntegerImpl(9, null);
        NestedInteger n10 = new NestedIntegerImpl(10, null);
        NestedInteger n11 = new NestedIntegerImpl(11, null);


        NestedInteger n21 = new NestedIntegerImpl(null, Collections.emptyList());

        NestedInteger n22 = new NestedIntegerImpl(null, List.of(n3, n5, n6));
        NestedInteger n23 = new NestedIntegerImpl(null, List.of(n7, n22, n8));

        NestedInteger n24 = new NestedIntegerImpl(null, List.of(n6, n9));
        NestedInteger n25 = new NestedIntegerImpl(null, List.of(n10, n4, n24, n11));

        List<NestedInteger> list = List.of(n21, n1, n23, n25, n2);

        NestedIterator iterator = new NestedIterator(list);
        List<Integer> result = new ArrayList<>();

        while (iterator.hasNext())
            result.add(iterator.next());

        result.forEach(x -> System.out.printf("%d ", x));

        // 1 7 3 5 6 8 10 4 6 9 11 2

    }

}


class NestedIterator implements Iterator<Integer> {

    private final Queue<Integer> items = new ArrayDeque<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        this.flattenList(nestedList);
    }

    @Override
    public Integer next() {
        return items.poll();
    }

    @Override
    public boolean hasNext() {
        return !items.isEmpty();
    }

    private void flattenList(List<NestedInteger> nestedList) {

        for (NestedInteger item:nestedList) {

            if (item.isInteger())
                items.offer(item.getInteger());
            else
                this.flattenList(item.getList());
        }
    }

}
