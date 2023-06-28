package algorithms.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountingSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] array) {

        if (array == null || array.length == 0) return array;

        int max = Arrays.stream(array).max().getAsInt();
        int [] auxiliaryArray = new int[max + 1];
        int [] result = new int[array.length];

        for (int j : array) auxiliaryArray[j]++;

        for (int i = 1; i < auxiliaryArray.length; i++)
            auxiliaryArray[i] += auxiliaryArray[i-1];

        for (int j : array)
            result[auxiliaryArray[j] - 1] = j;

        return result;
    }

    /**
     * Sorting the elements according to the place of a particular digit in a number
     */
    public void sort(int[] array, int place) {

        if (array == null || array.length == 0) return;

        int max = Arrays.stream(array).max().getAsInt();
        int [] auxiliaryArray = new int[max + 1];
        int [] result = new int[array.length];

        for (int j : array)
            auxiliaryArray[(j/place) % 10]++;

        for (int i = 1; i < auxiliaryArray.length; i++)
            auxiliaryArray[i] += auxiliaryArray[i-1];

        for (int j : array) {
            result[auxiliaryArray[(j / place) % 10] - 1] = j;
            auxiliaryArray[(j / place) % 10]--;
        }

        System.arraycopy(result, 0, array, 0, array.length);

    }


}
