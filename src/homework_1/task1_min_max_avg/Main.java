package homework_1.task1_min_max_avg;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] =(int) (Math.random() * 1000);
            }
        }

        //simple tests
        IntSummaryStatistics stats = Arrays.stream(arr)
                .flatMapToInt(Arrays::stream)
                .summaryStatistics();

        assert findMin(arr) == stats.getMin() : "Minimal value fail";
        assert findMax(arr) == stats.getMax() : "Maximum value fail";
        assert findAvg(arr) == stats.getAverage() : "Average value fail";
    }

    static int findMin(int[][] arr) {
        int min = arr[0][0];
        for (int[] subArr : arr) {
            for (int i : subArr) {
                if (i < min) min = i;
            }
        }
        return min;
    }

    static int findMax(int[][] arr) {
        int max = arr[0][0];;
        for (int[] subArr : arr) {
            for (int i : subArr) {
                if (i > max) max = i;
            }
        }
        return max;
    }

    static double findAvg(int[][] arr) {
        int sum = 0;
        for (int[] subArr : arr) {
            for (int i : subArr) {
                sum += i;
            }
        }
        return sum / Math.pow(arr.length, 2);
    }
}
