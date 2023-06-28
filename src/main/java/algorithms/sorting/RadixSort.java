package algorithms.sorting;

import java.util.Arrays;

public class RadixSort implements SortAlgorithm {

    CountingSort countingSort = new CountingSort();
    @Override
    public int[] sort(int[] array) {

        if (array == null || array.length == 0) return array;

        int max = Arrays.stream(array).max().getAsInt();

        for (int place = 1; max/place > 0; place *= 10) {
          countingSort.sort(array, place);
        }

        return array;
    }
}
