package algorithms.sorting;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {

        int[] input = new int[]{8, 5, 12, 14, 2, 21, 0};

        SortAlgorithm bubbleSort = new BubbleSort();
        bubbleSort.sort(input);

    }

    public static void print(String message, int[] array) {
        System.out.printf("%s: %s%n", message, Arrays.toString(array));
    }

}
