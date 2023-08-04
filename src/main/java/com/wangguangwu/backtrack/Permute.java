package com.wangguangwu.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangguangwu
 */
public class Permute {

    public static void main(String[] args) {
        Permute solution = new Permute();
        List<List<Integer>> result = solution.permute(new int[]{1, 2, 3});
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }

    List<List<Integer>> res = new LinkedList<>();

    /**
     * 主函数，输入一组不重复的数字，返回他们的全排列
     */
    List<List<Integer>> permute(int[] nums) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        // 「路径」中的元素会被标记为 true，避免重复使用
        boolean[] used = new boolean[nums.length];

        backtrack(nums, track, used);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除已经使用过的选择
            if (used[i]) {
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            track.add(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            track.removeLast();
            used[i] = false;
        }
    }
}
