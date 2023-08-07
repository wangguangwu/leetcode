package com.wangguangwu.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangguangwu
 */
public class SubsetsWithDup {

    public static void main(String[] args) {
        SubsetsWithDup solution = new SubsetsWithDup();
        int[] nums = {1, 2, 2};
        List<List<Integer>> lists = solution.subsetsWithDup(nums);
        System.out.println(lists);
    }

    List<List<Integer>> res = new LinkedList<>();

    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 先排序，让相同的元素靠在一起
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            // 剪枝，值相同地相邻树枝，只遍历第一条
            // 避免越界
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}
