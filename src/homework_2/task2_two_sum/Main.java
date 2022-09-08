package homework_2.task2_two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
        Task2
            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
*/
public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 4, 0, 5, 6, 2, 7};
        int[] result = twoSumHM(nums, 10); // O(n)
        System.out.println(Arrays.toString(result));

        int[] result2 = twoSum2For(nums, 10); // O(n^2)
        System.out.println(Arrays.toString(result2));
    }

    // Time complexity - O(n)
    public static int[] twoSumHM(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();

        for (int n : nums) {
            Integer complementNumber = complements.get(n);
            if (complementNumber != null) {
                return new int[]{complements.get(n), n};
            }
            complements.put(target - n, n);
        }
        return new int[]{};
    }

    // Time complexity - O(n^2)
    public static int[] twoSum2For(int[] nums, int target) {
        for (int i : nums) {
            for (int j : nums) {
                if (i + j == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }
}
