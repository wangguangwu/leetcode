package com.wangguangwu.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangguangwu
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.subsets(new int[]{1, 2, 3});
        System.out.println(result);
    }

    /**
     * 结果集
     */
    List<List<Integer>> res = new ArrayList<>();

    /**
     * 记录回溯算法的递归路径
     */
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    void backtrack(int[] nums, int start) {
        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));

        // 回溯算法
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);

            // 进入下一层决策树
            backtrack(nums, i + 1);

            // 撤销选择
            track.removeLast();
        }
    }
}
