package data_structures.queue;

public interface Queue <T> {

    void offer(T element);
    T poll();
    T peek();
    boolean isEmpty();
    boolean isFull();
    void display();
    int size();

}
