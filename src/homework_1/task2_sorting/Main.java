package homework_1.task2_sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] originalArr = {5, 6, 3, 2, 5, 1, 4, 9};
        int[] sortedArr = sort(originalArr);

        //simple test 1
        int[] expectedArr = Arrays.stream(originalArr).sorted().toArray();
        assert Arrays.equals(sortedArr, expectedArr) : "test 1 fail";

        //simple test 2
        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i] <= sortedArr[i + 1] : "test 2 fail";
        }
    }

    static public int[] sort(int[] arr) {
        int[] result = Arrays.copyOf(arr, arr.length);
        QuickSort.quickSort(result);
        return result;
    }

    private static class QuickSort {
        private static void quickSort(int[] a) {
            quickSort(a, 0, a.length - 1);
        }

        private static void quickSort(int[] a, int lo, int hi) {
            if(hi <= lo) return;
            int j = partition(a, lo, hi);
            quickSort(a, lo, j - 1);
            quickSort(a, j + 1, hi);
        }

        private static int partition(int[] a, int lo, int hi) {
            int i = lo;
            int j = hi + 1;
            int v = a[lo];

            while (true) {
                while (a[++i] < v)
                    if (i == hi) break;
                while (v < a[--j])
                    if (j == lo) break;

                if (i >= j) break;
                exch(a, i, j);
            }

            exch(a, lo, j);
            return j;
        }

        private static void exch(int[] arr, int i, int j) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }
}
