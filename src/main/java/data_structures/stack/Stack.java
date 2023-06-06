package data_structures.stack;

public interface Stack<T> {

    void push(T element);
    T peek();
    T pop();
    boolean isEmpty();
    boolean isFull();
    void printStack();
    int size();

}
