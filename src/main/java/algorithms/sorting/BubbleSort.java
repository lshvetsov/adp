package algorithms.sorting;

public class BubbleSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] array) {

        int size = array.length - 1;

        for (int i = 0; i < size; i++) {

            boolean swap = false;

            for (int j = 0; j < size - i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swap = true;
                }
            }

            if (!swap) break;

        }

        return array;

    }
}
