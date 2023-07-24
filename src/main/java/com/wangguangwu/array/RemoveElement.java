package com.wangguangwu.array;

import java.util.Arrays;

/**
 * @author wangguangwu
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        RemoveElement solution = new RemoveElement();
        int result = solution.removeElement(nums, 3);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
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
