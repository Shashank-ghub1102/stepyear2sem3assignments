package arrays.class_problems;

public class TwoSum {
    static int[] twoSum(int[] nums, int target) {
        for (int first = 0; first < nums.length; first++)
            for (int second = first + 1; second < nums.length; second++)
                if (nums[first] + nums[second] == target) return new int[]{first, second};
        return new int[0];
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result[0] + ", " + result[1]);
    }
}