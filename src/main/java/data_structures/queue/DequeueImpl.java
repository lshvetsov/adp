package data_structures.queue;

import java.util.Arrays;
import java.util.stream.Stream;

public class DequeueImpl<T> implements Dequeue<T> {

    Object[] array;
    int capacity;
    int front = -1;
    int rear = 0;
    int size;

    public DequeueImpl(int size) {
        this.capacity = size;
        this.array = new Object[size];
        this.size = array.length;
    }

    @Override
    public void offerFront(T element) {

        if (this.isFull()) throw new RuntimeException("Dequeue is full");

        if (front == -1) {
            front = 0;
            rear = 0;
        }
        else if (front == 0) front = size - 1;
        else front = front - 1;

        array[front] = element;

    }

    @Override
    public void offerRear(T element) {

        if (this.isFull()) throw new RuntimeException("Dequeue is full");

        if (front == -1) {
            front = 0;
            rear = 0;
        }
        else if (rear == size - 1) rear = 0;
        else rear = rear + 1;

        array[rear] = element;

    }

    @Override
    public T pollFront() {

        if (this.isEmpty()) throw new RuntimeException("Dequeue is empty");

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size-1) front = 0;
        else front = front + 1;

        return (T) array[front];

    }

    @Override
    public T pollRear() {

        if (this.isEmpty()) throw new RuntimeException("Dequeue is empty");

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) rear = size - 1;
        else rear = rear - 1;

        return (T) array[rear];
    }

    @Override
    public T peekFront() {

        if (this.isEmpty()) throw new RuntimeException("Dequeue is empty");
        return (T) array[front];

    }

    @Override
    public T peekRear() {

        if (this.isEmpty()) throw new RuntimeException("Dequeue is empty");
        return (T) array[rear];

    }

    @Override
    public void offer(T element) {
        this.offerRear(element);
    }

    @Override
    public T poll() {
        return this.pollFront();
    }

    @Override
    public T peek() {
        return this.peekFront();
    }

    @Override
    public boolean isEmpty() {
        return this.front == -1;
    }

    @Override
    public boolean isFull() {
        return (front == rear + 1) || (front == 0 && rear == array.length - 1);
    }

    @Override
    public void display() {
        System.out.println("-----------");
        System.out.printf("Front index = %d%n", front);
        System.out.printf("Rear index = %d%n", rear);

        if (front > rear) {
            Stream.concat(Arrays.stream(array).skip(front), Arrays.stream(array).limit(rear+1L))
                    .forEach(x ->System.out.printf("%s >> ", x));
        } else {
            Arrays.stream(array).skip(front).limit(rear).forEach(x ->System.out.printf("%s >> ", x));
        }
    }

    @Override
    public int size() {
        return 0;
    }

    public static void main(String[] args) {

        Dequeue<String> strings = new DequeueImpl<>(10);

        strings.offerFront("first_front");
        strings.offerFront("second_front");
        strings.offerFront("third_front");
        strings.offerRear("first_rear");
        strings.offerRear("second_rear");
        strings.offerRear("third_rear");
        strings.display();


    }

}
