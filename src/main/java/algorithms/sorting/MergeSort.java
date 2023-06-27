package algorithms.sorting;

import java.util.Arrays;

public class MergeSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] array) {
        return this.merge(array);
    }

    private int[] merge(int[] array) {

        if (array.length <= 1) return array;

        int half = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, half);
        int[] right = Arrays.copyOfRange(array, half, array.length);

        return this.mergeSortedArrays(
            this.merge(left),
            this.merge(right)
        );

    }

    private int[] mergeSortedArrays(int[]left, int[] right) {

        int[] result = new int[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;

        while (leftIndex < left.length && rightIndex < right.length) {

            if (left[leftIndex] < right[rightIndex]) {
                result[index++] = left[leftIndex++];
            } else {
                result[index++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) result[index++] = left[leftIndex++];
        while (rightIndex < right.length) result[index++] = right[rightIndex++];

        return result;

    }

}
