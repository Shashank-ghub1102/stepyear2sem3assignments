package arrays.class_problems;

import java.util.Arrays;

public class Week4_Arrays_RotateArray {
    static int[] rotateArray(int[] nums, int positions) {
        int[] rotated = new int[nums.length];
        if (nums.length == 0) return rotated;
        int shift = ((positions % nums.length) + nums.length) % nums.length;
        for (int index = 0; index < nums.length; index++) rotated[(index + shift) % nums.length] = nums[index];
        return rotated;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5}, 2)));
    }
}