package com.wangguangwu.array;

/**
 * 删除有序数组中的重复项
 *
 * @author wangguangwu
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates solution = new RemoveDuplicates();
        int[] array = {1, 1, 2};
        int result = solution.removeDuplicates(array);
        System.out.println(result);
    }

    /**
     * 双指针
     * <p>
     * 慢指针负责跟踪已处理的不重复元素
     * 快指针用于扫描数组以寻找新的不重复元素
     */
    private int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;

        int length = nums.length;
        while (fast < length) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }
        return ++slow;
    }
}
