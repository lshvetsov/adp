package algorithms.sorting;

public class InsertionSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int element = array[i];
            int j = i - 1;

            while (j >= 0 && element < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = element;
        }

        return array;
    }
}


