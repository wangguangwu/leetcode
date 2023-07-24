package com.wangguangwu.array;

import java.util.Arrays;

/**
 * @author wangguangwu
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 0, 0, 4};
        MoveZeroes solution = new MoveZeroes();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int currentLength = removeElement(nums, 0);
        for (int i = currentLength; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        int length = nums.length;
        while (fast < length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
