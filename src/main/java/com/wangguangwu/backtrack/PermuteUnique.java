package com.wangguangwu.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangguangwu
 */
public class PermuteUnique {

    public static void main(String[] args) {
        PermuteUnique solution = new PermuteUnique();
        int[] nums = {1, 2, 2};
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);
    }

    List<List<Integer>> res = new LinkedList<>();

    LinkedList<Integer> track = new LinkedList<>();

    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 排序
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums, used);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            int num = nums[i];
            // 做选择
            track.add(num);
            used[i] = true;
            // 回溯
            backtrack(nums, used);
            // 取消选择
            track.removeLast();
            used[i] = false;
        }
    }
}
