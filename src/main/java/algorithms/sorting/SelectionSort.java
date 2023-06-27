package algorithms.sorting;

public class SelectionSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] array) {

        int size = array.length;

        for (int i = 0; i < size; i++) {

            int minIndex = i;

            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[minIndex]) minIndex = j;
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        return array;

    }
}
