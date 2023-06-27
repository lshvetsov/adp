package algorithms.sorting;

public class QuickSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] array) {

        this.quickSort(array, 0, array.length-1);

        return array;
    }

    private void quickSort(int[] array, int leftIndex, int rightIndex) {

        if (leftIndex < rightIndex) {

            int i = partitionArray(array, leftIndex, rightIndex);

            quickSort(array, leftIndex, i-1);
            quickSort(array, i+1, rightIndex);

        }
    }

    private int partitionArray(int[] array, int leftIndex, int rightIndex) {

        int pivot = array[rightIndex];
        int low = leftIndex-1;

        for (int j = leftIndex; j < rightIndex; j++) {

            if (array[j] <= pivot) {
                low++;
                int temp = array[low];
                array[low] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[low + 1];
        array[low + 1] = pivot;
        array[rightIndex] = temp;

        return low + 1;
    }
}
