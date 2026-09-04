package arrays.class_problems;

public class Week4_Arrays_ContainsDuplicate {
    static boolean containsDuplicate(int[] nums) {
        for (int first = 0; first < nums.length; first++)
            for (int second = first + 1; second < nums.length; second++)
                if (nums[first] == nums[second]) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
    }
}