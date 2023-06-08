package data_structures.queue;

public interface Dequeue<T> extends Queue<T> {

    void offerFront(T element);
    void offerRear(T element);
    T pollFront();
    T pollRear();
    T peekFront();
    T peekRear();

}
