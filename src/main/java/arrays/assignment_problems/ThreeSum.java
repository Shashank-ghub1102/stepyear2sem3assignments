package arrays.assignment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> solutions = new ArrayList<>();
        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int left = first + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[first] + nums[left] + nums[right];
                if (sum == 0) {
                    solutions.add(new int[]{nums[first], nums[left], nums[right]});
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++; right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }
        return solutions.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        for (int[] solution : threeSum(new int[]{-1, 0, 1, 2, -1, -4})) System.out.println(Arrays.toString(solution));
    }
}