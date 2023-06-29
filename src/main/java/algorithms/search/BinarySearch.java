package algorithms.search;

public class BinarySearch {

    public int iterativeSearch(int[] array, int target) {

        for (int a = 0; a < array.length; a++) {
            if (array[a] == target) return a;
        }
        return -1;
    }

    public int recursiveSearch(int[] array, int target, int low, int high) {

        if (high >= low) {

            int mid = low + (high - low) / 2;
            if (array[mid] == target) return mid;

            if (target > array[mid]) {
                return recursiveSearch(array, target, mid + 1, high);
            } else {
                return recursiveSearch(array, target, low, mid - 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        BinarySearch searchEngine = new BinarySearch();

        System.out.println(searchEngine.iterativeSearch(new int[]{3, 7, 18, 31, 56, 75, 91}, 75) == 5);
        System.out.println(searchEngine.recursiveSearch(new int[]{3, 7, 18, 31, 56, 75, 91}, 75, 0, 6) == 5);

        System.out.println(searchEngine.iterativeSearch(new int[]{3, 7, 18, 31, 56, 75, 91}, 19) == -1);
        System.out.println(searchEngine.recursiveSearch(new int[]{3, 7, 18, 31, 56, 75, 91}, 19, 0, 6) == -1);

    }

}
