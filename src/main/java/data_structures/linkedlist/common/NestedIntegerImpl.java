package data_structures.linkedlist.common;

import java.util.Collections;
import java.util.List;

public class NestedIntegerImpl implements NestedInteger {

    private final Integer number;
    private final List<NestedInteger> list;

    public NestedIntegerImpl(Integer number, List<NestedInteger> list) {
        this.number = number;
        this.list = number == null ? list : null;
    }

    @Override
    public boolean isInteger() {
        return number != null;
    }

    @Override
    public Integer getInteger() {
        return number;
    }

    @Override
    public List<NestedInteger> getList() {
        return list == null ? Collections.emptyList() : list;
    }
}
