package algorithms.sorting;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {

        Sorting.execute(new BubbleSort(), new int[]{8, 5, 12, 14, 2, 21, 0});
        Sorting.execute(new SelectionSort(), new int[]{8, 5, 12, 14, 2, 21, 0});
        Sorting.execute(new InsertionSort(), new int[]{8, 5, 12, 14, 2, 21, 0});
        Sorting.execute(new MergeSort(), new int[]{8, 5, 12, 14, 2, 21, 0});
        Sorting.execute(new QuickSort(), new int[]{8, 5, 12, 14, 2, 21, 0});

    }

    public static void execute(SortAlgorithm sortingAlgorithm, int[] array) {

        String algorithmsName = sortingAlgorithm.getClass().getSimpleName();

        Sorting.print(String.format("%s, initial array", algorithmsName), array);

        long start = System.currentTimeMillis();
        int[] sortedArray = sortingAlgorithm.sort(array);
        long end = System.currentTimeMillis();

        Sorting.print(String.format("%s, result array, sorting in %d", algorithmsName, end - start), sortedArray);
    }

    public static void print(String message, int[] array) {
        System.out.printf("%s: %s%n", message, Arrays.toString(array));
    }
}
