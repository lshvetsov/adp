package data_structures.queue;

public class QueueImpl<T> implements Queue<T> {

    Object[] array;
    int capacity;
    int front = -1;
    int rear = -1;

    public QueueImpl(int size) {
        this.capacity = size;
        this.array = new Object[size];
    }

    @Override
    public void offer(T element) {

        if (this.isFull()) throw new RuntimeException("Queue is full, please poll any item first");
        if (this.front == -1) this.front = 0;

        array[++rear] = element;

    }

    @Override
    public T poll() {

        if (this.isEmpty()) throw new RuntimeException("Queue is empty, please offer any item first");

        Object result = this.array[front];

        if (this.front >= this.rear) {
            this.front = -1;
            this.rear = -1;
        } else {
            front++;
        }

        return (T) result;

    }

    @Override
    public T peek() {

        if (this.isEmpty()) return null;

        return (T) this.array[front];
    }

    @Override
    public boolean isEmpty() {
        return this.front == -1;
    }

    @Override
    public boolean isFull() {
        return this.rear >= capacity - 1;
    }

    @Override
    public void display() {

        System.out.println("-----------------------");

        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.printf("Front index is %d%n", this.front);

        for (int i = this.front; i <= this.rear; i++) {
            System.out.printf("%s%n", array[i]);
        }

        System.out.printf("Rear index is %d%n", this.rear);

        if (this.isFull()) System.out.println("Queue is full");

    }

    @Override
    public int size() {
        return this.rear - this.front;
    }

    public static void main(String[] args) {

        Queue<String> queue = new QueueImpl<>(3);

        queue.offer("first");
        queue.offer("second");
        queue.offer("third");
        queue.display();
    }

}
