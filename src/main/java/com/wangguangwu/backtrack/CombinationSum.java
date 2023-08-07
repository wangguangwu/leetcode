package com.wangguangwu.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangguangwu
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] nums = {2, 3, 5};
        List<List<Integer>> lists = solution.combinationSum(nums, 8);
        System.out.println(lists);
    }

    List<List<Integer>> res = new LinkedList<>();

    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            // 没有这样的值
            if (candidate > target) {
                break;
            }
            // 做选择
            track.add(candidate);
            // 回溯
            backtrack(candidates, target - candidate, i);
            // 取消选择
            track.removeLast();
        }
    }
}
