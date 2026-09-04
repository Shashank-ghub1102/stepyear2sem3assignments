package arrays.assignment_problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0, 1);
        int prefix = 0, count = 0;
        for (int number : nums) {
            prefix += number;
            count += prefixCounts.getOrDefault(prefix - k, 0);
            prefixCounts.put(prefix, prefixCounts.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }
}