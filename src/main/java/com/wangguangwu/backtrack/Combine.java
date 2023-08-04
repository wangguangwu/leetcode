package com.wangguangwu.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangguangwu
 */
public class Combine {

    public static void main(String[] args) {
        Combine solution = new Combine();
        List<List<Integer>> combine = solution.combine(4, 2);
        System.out.println(combine);
    }

    List<List<Integer>> res = new LinkedList<>();

    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k > n) {
            return res;
        }
        // 不需要空集合
        backtrack(1, n, k);
        return res;
    }

    public void backtrack(int start, int n, int k) {
        // base case
        if (k == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }
        // 回溯
        for (int i = start; i <= n; i++) {
            // 做选择
            track.addLast(i);
            // 进入决策树
            backtrack(i + 1, n, k);
            // 取消选择
            track.removeLast();
        }
    }
}
