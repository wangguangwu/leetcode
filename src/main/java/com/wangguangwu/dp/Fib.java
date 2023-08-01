package com.wangguangwu.dp;

/**
 * 斐波那契数列：每个数字都是前两个数字的和
 * <p>
 * 递归算法的时间复杂度：子问题个数 * 解决一个子问题需要的时间
 *
 * @author wangguangwu
 */
public class Fib {

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib1(10));
        System.out.println(fib.fib2(10));
        System.out.println(fib.fib3(10));
    }

    public int fib1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        // 二叉树 节点总数为指数级别，子问题个数为 O(2 ^ n)
        // 子问题中只有一个加法操作，时间为 O(1)
        // 时间复杂度：O(2 ^ n)
        return fib1(n - 1) + fib1(n - 2);
    }

    public int fib2(int n) {
        // 带备忘录的递归方法
        int[] memo = new int[n + 1];
        return dp(memo, n);
    }

    private int dp(int[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        // 使用备忘录，把一颗存在巨量冗余的递归树通过「剪枝」，改造成了一幅不存在冗余的递归图
        // 减少了子问题的个数
        // 本算法不存在冗余计算，子问题数量与输入规模 n 成正比，所以时间复杂度是 O(n)
        // 解决一个子问题的时间是 O(1)
        // 时间复杂度：O(n)
        memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
        return memo[n];
    }

    public int fib3(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        // 状态转移
        // 自底向上
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
