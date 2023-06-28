package algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort implements SortAlgorithm {
    @Override
    public int[] sort(int[] array) {

        if (array == null || array.length == 0) return array;
        int size = array.length;

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] buckets = new ArrayList[size];

        for(int i = 0; i < size; i++)
            buckets[i] = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            int bucketIndex = array[i] / 10;
            buckets[bucketIndex].add(array[i]);
        }

        for(int i = 0; i < size; i++)
            Collections.sort(buckets[i]);

        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                array[index++] = buckets[i].get(j);
            }
        }

        return array;
    }
}
