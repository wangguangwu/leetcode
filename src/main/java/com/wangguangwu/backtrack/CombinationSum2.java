package com.wangguangwu.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangguangwu
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        CombinationSum2 solution = new CombinationSum2();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = solution.combinationSum2(candidates, 8);
        System.out.println(lists);
    }

    List<List<Integer>> res = new LinkedList<>();

    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            // 剪枝
            if (i > start && candidates[i] == candidates[i -1]) {
                continue;
            }
            int candidate = candidates[i];
            // 再剪枝
            // 如果当前数字大于 target，后续的也不可能达成目标
            if (candidate > target) {
                break;
            }
            // 做选择
            track.add(candidate);
            // 回溯
            backtrack(candidates, target - candidate, i + 1);
            // 取消选择
            track.removeLast();
        }
    }
}
