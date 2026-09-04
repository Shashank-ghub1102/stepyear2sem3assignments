package arrays.assignment_problems;

import java.util.Arrays;

public class Week4_Arrays_ProductOfArrayExceptSelf {
    static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) { result[i] = prefix; prefix *= nums[i]; }
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) { result[i] *= suffix; suffix *= nums[i]; }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}