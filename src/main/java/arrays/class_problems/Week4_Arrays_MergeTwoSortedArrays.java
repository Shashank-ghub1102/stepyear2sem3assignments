package arrays.class_problems;

import java.util.Arrays;

public class Week4_Arrays_MergeTwoSortedArrays {
    static int[] mergeSortedArrays(int[] first, int[] second) {
        int[] merged = new int[first.length + second.length];
        int left = 0, right = 0, index = 0;
        while (left < first.length && right < second.length)
            merged[index++] = first[left] <= second[right] ? first[left++] : second[right++];
        while (left < first.length) merged[index++] = first[left++];
        while (right < second.length) merged[index++] = second[right++];
        return merged;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6})));
    }
}