package data_structures.stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Custom educational implementation of the stack
 */
public class StackImpl<T> implements Stack<T> {

    Object[] array;
    int capacity;
    int pointer = -1;

    public StackImpl(int size) {
        this.capacity = size;
        this.array = new Object[size];
    }

    @Override
    public void push(T element) {

        if (this.isFull()) {
            throw new RuntimeException("Stack is full, please pop some elements from it");
        }

        this.array[++pointer] = element;
        System.out.printf("%s is added to the stack, %d empty slots left%n", element, capacity - pointer - 1);

    }

    @Override
    public T peek() {
        if (!this.isEmpty()) {
            return (T) this.array[pointer];
        }
        return null;
    }

    @Override
    public T pop() {
        if (this.isEmpty()) {
            return null;
        }
        System.out.printf("%s is taken from the stack, %d empty slots left%n", this.array[pointer-1], capacity - pointer);
        return (T) this.array[pointer--];
    }

    @Override
    public boolean isEmpty() {
        return this.pointer == -1;
    }

    @Override
    public boolean isFull() {
        return this.pointer == capacity-1;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
    @Override
    public void printStack() {
        Arrays.stream(array).forEach(x -> System.out.print(x + " "));
    }

    @Override
    public int size() {
        return capacity;
    }

    public static void main(String[] args) {

        Stack<String> stack = new StackImpl<>(5);
        System.out.println(stack.size());

        Stream.generate(() -> "string").limit(5).forEach(stack::push);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push("new");
        stack.printStack();
        stack.push("one more");

    }


}
